package com.example.kmmfirst

import com.example.kmmfirst.core.KotlinUIComponent
import com.example.kmmfirst.core.KotlinUIProvider
import com.example.kmmfirst.core.types.KotlinUIProviderContext
import com.example.kmmfirst.core.UIBuilder
import com.example.kmmfirst.core.vStack

class Greeting {

    private val platform: Platform = getPlatform()
    private val cache: MutableMap<UInt, KotlinUIComponent?> = mutableMapOf()

    fun greeting(): String {
        return "Hello, ${platform.name}!"
    }

    fun element(provider: KotlinUIProvider): List<KotlinUIComponent> {
        val builder = UIBuilder()
        builder.vStack {
        }
        val elements = builder.build().mapNotNull {
            it.base.createComponent(provider, KotlinUIProviderContext(it.id, cache[it.id]))
        }
        return elements
    }
}