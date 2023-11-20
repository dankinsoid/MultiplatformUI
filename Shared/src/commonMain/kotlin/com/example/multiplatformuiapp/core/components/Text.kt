package com.example.multiplatformuiapp.core.components

import com.example.multiplatformuiapp.core.BaseComponent
import com.example.multiplatformuiapp.core.KotlinUIComponent
import com.example.multiplatformuiapp.core.KotlinUIProvider
import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIBuilder
import com.example.multiplatformuiapp.core.UIEnvironment
import com.example.multiplatformuiapp.core.UIEnvironmentKey
import com.example.multiplatformuiapp.core.types.KotlinUIProviderContext

fun UIBuilder.text(text: String): UI = add(
    subview = Text()
) {
    it.text = text
}

private class Text: BaseComponent {

    override fun createComponent(provider: KotlinUIProvider, context: KotlinUIProviderContext): KotlinUIComponent {
        return provider.makeText(context)
    }
}

private class TextKey: UIEnvironmentKey

internal var UIEnvironment.text: String
    get() = this[TextKey()] ?: ""
    set(value) {
        this[TextKey()] = value
    }
