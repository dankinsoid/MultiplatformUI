package com.example.multiplatformuiapp.core.layouts

import com.example.multiplatformuiapp.core.BaseComponent
import com.example.multiplatformuiapp.core.KotlinUIComponent
import com.example.multiplatformuiapp.core.KotlinUIProvider
import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIBuilder
import com.example.multiplatformuiapp.core.types.KotlinUILayoutSubview
import com.example.multiplatformuiapp.core.types.KotlinUIProviderContext
import com.example.multiplatformuiapp.core.types.ProposedUISize
import com.example.multiplatformuiapp.core.types.UIRect
import com.example.multiplatformuiapp.core.types.UISize

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
