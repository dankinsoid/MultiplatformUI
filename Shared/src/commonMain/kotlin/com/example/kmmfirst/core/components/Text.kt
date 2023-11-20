package com.example.kmmfirst.core.components

import com.example.kmmfirst.core.BaseComponent
import com.example.kmmfirst.core.KotlinUIComponent
import com.example.kmmfirst.core.KotlinUIProvider
import com.example.kmmfirst.core.UI
import com.example.kmmfirst.core.UIBuilder
import com.example.kmmfirst.core.UIEnvironment
import com.example.kmmfirst.core.UIEnvironmentKey
import com.example.kmmfirst.core.types.KotlinUIProviderContext

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
