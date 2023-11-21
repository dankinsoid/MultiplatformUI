package com.example.multiplatformuiapp.core

import com.example.multiplatformuiapp.core.layouts.UILayout

sealed class UIElement(val classID: String) {

    data class Layout(
        val layout: UILayout,
        val builder: UIBuilder
    ) : UIElement(classID = layout::class.qualifiedName ?: "${layout::class}")
    data class Component(
        val component: BaseComponent
    ) : UIElement(classID = component::class.qualifiedName ?: "${component::class}")
}
