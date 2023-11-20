package com.example.kmmfirst.core.components

import com.example.kmmfirst.core.UI
import com.example.kmmfirst.core.UIEnvironment

fun UI.environment(modify: (UIEnvironment) -> Unit) = this.also { view ->
    val currentMap = view.mapUIEnvironment
    view.mapUIEnvironment = { environment ->
        currentMap(environment)
        modify(environment)
    }
}
