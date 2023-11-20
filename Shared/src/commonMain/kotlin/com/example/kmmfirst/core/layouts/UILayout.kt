package com.example.kmmfirst.core.layouts

import com.example.kmmfirst.core.UI
import com.example.kmmfirst.core.types.ProposedUISize
import com.example.kmmfirst.core.types.UIRect
import com.example.kmmfirst.core.types.UISize

interface UILayout {

    fun sizeThatFits(proposal: ProposedUISize, subviews: List<UI>): UISize {
        return UISize(proposal.width ?: 0.0, proposal.height ?: 0.0)
    }

    fun placeSubviewsIn(
        bounds: UIRect,
        proposal: ProposedUISize,
        subviews: List<UI>
    ) {
    }
}