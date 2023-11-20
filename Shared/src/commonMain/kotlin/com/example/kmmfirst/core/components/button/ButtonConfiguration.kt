package com.example.kmmfirst.core.components.button

import com.example.kmmfirst.core.UIEnvironment
import com.example.kmmfirst.core.UIEnvironmentKey

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
