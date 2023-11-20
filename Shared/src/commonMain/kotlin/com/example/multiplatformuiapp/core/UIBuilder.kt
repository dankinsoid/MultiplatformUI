package com.example.multiplatformuiapp.core

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

    fun add(subview: BaseComponent, modify: ((UIEnvironment) -> Unit)? = null): UI {
        val id = subview::class.qualifiedName ?: "${subview::class}"
        val ui = UI(id, subview, modify ?: {})
        subviews.add(ui)
        return ui
    }
}
