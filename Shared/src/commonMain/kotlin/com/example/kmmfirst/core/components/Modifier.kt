package com.example.kmmfirst.core.components

import com.example.kmmfirst.core.UI

interface UIModifier {

    fun body(ui: UI): UI
}

fun UI.modifier(modifier: UIModifier): UI = modifier.body(this)
