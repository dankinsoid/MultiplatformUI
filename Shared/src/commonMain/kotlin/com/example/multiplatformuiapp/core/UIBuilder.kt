package com.example.multiplatformuiapp.core

import com.example.multiplatformuiapp.core.layouts.UILayout

data class UIBuilder(
    private val block: UIBuilder.() -> Unit = {}
) {

    private val subviews: MutableList<UI> = mutableListOf()

    val environment: UIEnvironment
        get() = UIEnvironment.current

    fun build(): List<UI> {
        block()
        val result = subviews
        subviews.clear()
        return result
    }

    fun layout(layout: UILayout, children: UIBuilder.() -> Unit, modify: ((UIEnvironment) -> Unit)? = null): UI {
        return add(UIElement.Layout(layout, UIBuilder(children)), modify)
    }

    fun component(component: BaseComponent, modify: ((UIEnvironment) -> Unit)? = null): UI {
        return  add(UIElement.Component(component), modify)
    }

    private fun add(element: UIElement, modify: ((UIEnvironment) -> Unit)? = null): UI {
        val ui = UI(element.classID, element, modify ?: {})
        subviews.add(ui)
        return ui
    }
}
