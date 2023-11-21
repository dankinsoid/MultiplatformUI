package com.example.multiplatformuiapp.core.layouts

import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.types.LayoutProperties
import com.example.multiplatformuiapp.core.types.ProposedUISize
import com.example.multiplatformuiapp.core.types.UIRect
import com.example.multiplatformuiapp.core.types.UISize

interface UILayout {

    val properties: LayoutProperties
        get() = LayoutProperties()

    fun sizeThatFits(proposal: ProposedUISize, subviews: List<UI>): UISize {
        return UISize(proposal.width ?: 0.0, proposal.height ?: 0.0)
    }

    fun placeSubviewsIn(
        bounds: UIRect,
        subviews: List<UI>,
        place: (String, UIRect) -> Unit
    ) {
    }
}
