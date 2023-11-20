package com.example.kmmfirst.core.layouts

import com.example.kmmfirst.core.BaseComponent
import com.example.kmmfirst.core.KotlinUIComponent
import com.example.kmmfirst.core.KotlinUIProvider
import com.example.kmmfirst.core.UI
import com.example.kmmfirst.core.UIBuilder
import com.example.kmmfirst.core.types.KotlinUILayoutSubview
import com.example.kmmfirst.core.types.KotlinUIProviderContext
import com.example.kmmfirst.core.types.ProposedUISize
import com.example.kmmfirst.core.types.UIRect
import com.example.kmmfirst.core.types.UISize

fun UIBuilder.layout(layout: UILayout, ui: UIBuilder.() -> Unit): UI = add(
    subview = Layout(layout, UIBuilder(ui))
)

private class Layout(
    private val layout: UILayout,
    private val uiBuilder: UIBuilder
): BaseComponent {

    override fun sizeThatFits(proposal: ProposedUISize, component: KotlinUIComponent?): UISize = layout.sizeThatFits(proposal, listOf())

    override fun createComponent(provider: KotlinUIProvider, context: KotlinUIProviderContext): KotlinUIComponent = provider.makeLayout(
        uiBuilder.build().mapNotNull {
            KotlinUILayoutSubview(
                it.id,
                it.base.createComponent(provider, context) ?: return@mapNotNull null,
                UIRect()
            )
        },
        context
    )

    override fun update(component: KotlinUIComponent?, context: KotlinUIProviderContext) {
        super.update(component, context)
    }
}
