package com.example.multiplatformuiapp.core.components

import com.example.multiplatformuiapp.core.BaseComponent
import com.example.multiplatformuiapp.core.KotlinUIComponent
import com.example.multiplatformuiapp.core.KotlinUIProvider
import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIBuilder
import com.example.multiplatformuiapp.core.UIValues
import com.example.multiplatformuiapp.core.UIValuesKey
import com.example.multiplatformuiapp.core.types.KotlinUIProviderContext

fun UIBuilder.text(text: String): UI = component(Text()).values {
    it.text = text
}

private class Text: BaseComponent {

    override fun createComponent(provider: KotlinUIProvider, context: KotlinUIProviderContext): KotlinUIComponent {
        return provider.makeText(context)
    }
}

private class TextKey: UIValuesKey<String>

var UIValues.text: String
    get() = this[TextKey::class] ?: ""
    set(value) {
        this[TextKey::class] = value
    }
