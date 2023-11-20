package com.example.multiplatformuiapp.core.components

import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIEnvironment

fun UI.environment(modify: (UIEnvironment) -> Unit) = this.also { view ->
    val currentMap = view.mapUIEnvironment
    view.mapUIEnvironment = { environment ->
        currentMap(environment)
        modify(environment)
    }
}
