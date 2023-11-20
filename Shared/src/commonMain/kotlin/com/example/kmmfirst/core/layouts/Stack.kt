package com.example.kmmfirst.core.layouts

import com.example.kmmfirst.core.UI
import com.example.kmmfirst.core.UIBuilder
import com.example.kmmfirst.core.types.Axis

fun UIBuilder.vStack(spacing: Double = 0.0, ui: UIBuilder.() -> Unit): UI = layout(Stack(Axis.VERTICAL, spacing), ui)

private data class Stack(
    val axis: Axis,
    val spacing: Double
): UILayout {
}
