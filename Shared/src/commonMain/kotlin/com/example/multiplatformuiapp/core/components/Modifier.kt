package com.example.multiplatformuiapp.core.components

import com.example.multiplatformuiapp.core.UI

interface UIModifier {

    fun body(ui: UI): UI
}

fun UI.modifier(modifier: UIModifier): UI = modifier.body(this)
