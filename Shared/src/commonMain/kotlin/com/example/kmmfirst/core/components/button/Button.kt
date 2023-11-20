package com.example.kmmfirst.core.components.button

import com.example.kmmfirst.core.BaseComponent
import com.example.kmmfirst.core.KotlinUIComponent
import com.example.kmmfirst.core.KotlinUIProvider
import com.example.kmmfirst.core.UI
import com.example.kmmfirst.core.UIBuilder
import com.example.kmmfirst.core.components.text
import com.example.kmmfirst.core.types.KotlinUIProviderContext

fun UIBuilder.button(tap: () -> Unit, label: UIBuilder.() -> UI): UI = this.label()

fun UIBuilder.button(title: String, tap: () -> Unit): UI = button(tap) {
    text(title)
}

private data class Button(
    private val content: () -> UI
): BaseComponent {

    override fun createComponent(
        provider: KotlinUIProvider,
        context: KotlinUIProviderContext
    ): KotlinUIComponent = provider.makeButton(context)
}
