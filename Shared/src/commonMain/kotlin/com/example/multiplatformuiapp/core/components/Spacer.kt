package com.example.multiplatformuiapp.core.components

import com.example.multiplatformuiapp.core.BaseComponent
import com.example.multiplatformuiapp.core.KotlinUIComponent
import com.example.multiplatformuiapp.core.KotlinUIProvider
import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIBuilder
import com.example.multiplatformuiapp.core.types.KotlinUIProviderContext
import com.example.multiplatformuiapp.core.types.ProposedUISize
import com.example.multiplatformuiapp.core.types.UISize

fun UIBuilder.spacer(): UI = add(
    subview = Spacer()
)

private class Spacer: BaseComponent {

    override fun createComponent(provider: KotlinUIProvider, context: KotlinUIProviderContext): KotlinUIComponent? = null

    override fun sizeThatFits(proposal: ProposedUISize, component: KotlinUIComponent?): UISize {
        return UISize(proposal.width ?: 0.0, proposal.height ?: 0.0)
    }
}
