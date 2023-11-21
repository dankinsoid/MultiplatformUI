package com.example.multiplatformuiapp.core.layouts

import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIBuilder
import com.example.multiplatformuiapp.core.types.Axis
import com.example.multiplatformuiapp.core.types.LayoutProperties
import com.example.multiplatformuiapp.core.types.ProposedUISize
import com.example.multiplatformuiapp.core.types.UIPoint
import com.example.multiplatformuiapp.core.types.UIRect
import com.example.multiplatformuiapp.core.types.UISize
import com.example.multiplatformuiapp.core.types.get
import com.example.multiplatformuiapp.core.types.opposite
import com.example.multiplatformuiapp.core.types.proposalSize
import com.example.multiplatformuiapp.core.types.set
import kotlin.math.abs
import kotlin.math.max

fun UIBuilder.vStack(spacing: Double = 0.0, ui: UIBuilder.() -> Unit): UI = layout(Stack(Axis.VERTICAL, spacing), ui)
fun UIBuilder.hStack(spacing: Double = 0.0, ui: UIBuilder.() -> Unit): UI = layout(Stack(Axis.HORIZONTAL, spacing), ui)

private data class Stack(
    val axis: Axis,
    val spacing: Double
): UILayout {
    private var subviewsSizes: List<UISize> = emptyList()

    override val properties: LayoutProperties
        get() = LayoutProperties(axis)

    override fun sizeThatFits(proposal: ProposedUISize, subviews: List<UI>): UISize {
        if (subviews.isEmpty()) { return UISize() }

        val fullSpacing = spacing * (subviews.size - 1)
        val unspecifiedSizes = subviews.indices.map {
            subviews[it].sizeThatFits(
                when (axis) {
                    Axis.HORIZONTAL -> ProposedUISize(null, proposal.height)
                    Axis.VERTICAL -> ProposedUISize(proposal.width, null)
                }
            )
        }.toMutableList()

        var unspecifiedSize: UISize = reduce(unspecifiedSizes)
        unspecifiedSize[axis] += fullSpacing

        if (proposal[axis]?.let { size -> size != unspecifiedSize[axis] } == true) {
            val size = proposal[axis] ?: 0.0
            val dif = size - unspecifiedSize[axis]
            add(dif, subviews, unspecifiedSizes)
            unspecifiedSize = reduce(unspecifiedSizes)
        }
        this.subviewsSizes = unspecifiedSizes
        return unspecifiedSize
    }

    override fun placeSubviewsIn(
        bounds: UIRect,
        subviews: List<UI>,
        place: (String, UIRect) -> Unit
    ) {
        if (subviews.isEmpty()) { return }
        if (subviewsSizes.isEmpty()) {
            sizeThatFits(
                ProposedUISize(bounds.size.width, bounds.size.height),
                subviews
            )
        }
        var origin = bounds.origin[axis]
        for (i in subviews.indices) {
            val rect = UIRect(
                when (axis) {
                    Axis.HORIZONTAL -> UIPoint(origin, bounds.origin.y)
                    Axis.VERTICAL -> UIPoint(bounds.origin.x, origin)
                },
                subviewsSizes[i]
            )
            subviews[i].placeSubviewsIn(rect, place)
            origin += subviewsSizes[i][axis] + spacing
        }
    }

    private fun add(
        value: Double,
        subviews: List<UI>,
        sizes: MutableList<UISize>
    ) {
        if (value == 0.0) { return }
        var value = value
        val groups = subviews
            .asSequence()
            .withIndex()
            .groupBy { it.value.layoutProperties.priority }
            .toList()
            .sortedBy { it.first }
            .map { indexedValue -> indexedValue.second.map { it.index to it.value } }.toList()

        for (group in groups) {
            val eachValue = value / group.size
            for ((i, layout) in group) {
                val oldValue = sizes[i][axis]
                sizes[i] = layout.sizeThatFits(
                    axis.proposalSize(
                        sizes[i][axis] + eachValue,
                        sizes[i][axis.opposite]
                    )
                )
                val newValue = sizes[i][axis]
                value -= (newValue - oldValue)
            }
            if (abs(value) <= 0.001) {
                return
            }
        }
    }

    private fun reduce(sizes: List<UISize>): UISize = sizes.reduce { partialResult, itemSize ->
        return when (axis) {
            Axis.HORIZONTAL -> UISize(
                partialResult.width + itemSize.width,
                max(partialResult.height, itemSize.height)
            )

            Axis.VERTICAL -> UISize(
                max(partialResult.width, itemSize.width),
                partialResult.height + itemSize.height
            )
        }
    }
}
