package com.example.multiplatformuiapp.core

import com.example.multiplatformuiapp.core.types.ProposedUISize
import com.example.multiplatformuiapp.core.types.UISize

data class UI(
    var id: String,
    private var element: UIElement,
    internal var mapUIEnvironment: (UIEnvironment) -> Unit,
    private var values: UIValues = UIValues()
) {

    val environment: UIEnvironment
        get() = UIEnvironment.current.map(mapUIEnvironment)

    fun values(modify: (UIValues) -> Unit) = this.also { view ->
        modify(view.values)
    }

    fun environment(modify: (UIEnvironment) -> Unit) = this.also { view ->
        val currentMap = view.mapUIEnvironment
        view.mapUIEnvironment = { environment ->
            currentMap(environment)
            modify(environment)
        }
    }

    fun sizeThatFits(proposal: ProposedUISize): UISize {
        return when (val element = this.element) {
            is UIElement.Component -> element.component.sizeThatFits(proposal, null)
            is UIElement.Layout -> element.layout.sizeThatFits(proposal, element.builder.build())
        }
    }
}

