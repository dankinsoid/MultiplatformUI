package com.example.multiplatformuiapp.core.layouts

import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIBuilder
import com.example.multiplatformuiapp.core.types.Axis

fun UIBuilder.vStack(spacing: Double = 0.0, ui: UIBuilder.() -> Unit): UI = layout(Stack(Axis.VERTICAL, spacing), ui)

private data class Stack(
    val axis: Axis,
    val spacing: Double
): UILayout {
}
