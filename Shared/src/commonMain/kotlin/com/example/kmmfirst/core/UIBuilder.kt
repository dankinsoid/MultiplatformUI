package com.example.kmmfirst.core

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

    fun add(id: String? = null, subview: BaseComponent, modify: ((UIEnvironment) -> Unit)? = null): UI {
        val ui = UI(id ?: "${subviews.size}", subview, modify ?: {})
        subviews.add(ui)
        return ui
    }
}
