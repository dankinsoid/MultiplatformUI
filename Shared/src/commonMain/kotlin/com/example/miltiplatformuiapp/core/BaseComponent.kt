package com.example.kmmfirst.core

import com.example.kmmfirst.core.types.KotlinUIProviderContext
import com.example.kmmfirst.core.types.ProposedUISize
import com.example.kmmfirst.core.types.UISize

interface BaseComponent {

    fun createComponent(provider: KotlinUIProvider, context: KotlinUIProviderContext): KotlinUIComponent?

    fun sizeThatFits(proposal: ProposedUISize, component: KotlinUIComponent?): UISize {
        return component?.sizeThatFits(proposal) ?: UISize()
    }

    fun update(component: KotlinUIComponent?, context: KotlinUIProviderContext) {
        component?.update(context)
    }
}
