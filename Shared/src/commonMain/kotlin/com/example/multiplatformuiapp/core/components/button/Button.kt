package com.example.multiplatformuiapp.core.components.button

import com.example.multiplatformuiapp.core.BaseComponent
import com.example.multiplatformuiapp.core.KotlinUIComponent
import com.example.multiplatformuiapp.core.KotlinUIProvider
import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIBuilder
import com.example.multiplatformuiapp.core.components.text
import com.example.multiplatformuiapp.core.types.KotlinUIProviderContext

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
