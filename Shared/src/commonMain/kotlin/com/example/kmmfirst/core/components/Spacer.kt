package com.example.kmmfirst.core.components

import com.example.kmmfirst.core.BaseComponent
import com.example.kmmfirst.core.KotlinUIComponent
import com.example.kmmfirst.core.KotlinUIProvider
import com.example.kmmfirst.core.UI
import com.example.kmmfirst.core.UIBuilder
import com.example.kmmfirst.core.types.KotlinUIProviderContext
import com.example.kmmfirst.core.types.ProposedUISize
import com.example.kmmfirst.core.types.UISize

fun UIBuilder.spacer(): UI = add(
    subview = Spacer()
)

private class Spacer: BaseComponent {

    override fun createComponent(provider: KotlinUIProvider, context: KotlinUIProviderContext): KotlinUIComponent? = null

    override fun sizeThatFits(proposal: ProposedUISize, component: KotlinUIComponent?): UISize {
        return UISize(proposal.width ?: 0.0, proposal.height ?: 0.0)
    }
}
