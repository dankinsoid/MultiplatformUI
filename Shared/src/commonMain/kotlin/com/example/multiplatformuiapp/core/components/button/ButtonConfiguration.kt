package com.example.multiplatformuiapp.core.components.button

import com.example.multiplatformuiapp.core.UIEnvironment
import com.example.multiplatformuiapp.core.UIEnvironmentKey

data class ButtonConfiguration(
    val isEnabled: Boolean = true,
    val onHighlight: (Boolean) -> Unit = {},
    val onTap: () -> Unit = {}
)

private class ButtonConfigurationKey: UIEnvironmentKey

var UIEnvironment.buttonConfiguration: ButtonConfiguration
    get() = this[ButtonConfigurationKey()] ?: ButtonConfiguration()
    set(value) {
        this[ButtonConfigurationKey()] = value
    }
