package com.example.multiplatformuiapp.core.components

import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIBuilder
import com.example.multiplatformuiapp.core.layouts.UILayout

fun UIBuilder.spacer(): UI = layout(Spacer(), {})

private class Spacer: UILayout {
}
