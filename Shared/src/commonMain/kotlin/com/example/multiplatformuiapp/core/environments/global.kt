package com.example.multiplatformuiapp.core.environments

import com.example.multiplatformuiapp.core.UIEnvironment
import com.example.multiplatformuiapp.core.UIEnvironmentKey
import com.example.multiplatformuiapp.core.types.Color

private class BackgroundColorKey: UIEnvironmentKey

var UIEnvironment.backgroundColor: Color
    get() = this[BackgroundColorKey::class] ?: Color(0.0, 0.0, 0.0, 0.0)
    set(value) {
        this[BackgroundColorKey::class] = value
    }

private class ForegroundColorKey: UIEnvironmentKey

var UIEnvironment.foregroundColor: Color
    get() = this[ForegroundColorKey::class] ?: Color(0.0, 0.0, 0.0, 1.0)
    set(value) {
        this[ForegroundColorKey::class] = value
    }

private class IsEnabledKey: UIEnvironmentKey

var UIEnvironment.isEnabled: Boolean
    get() = this[IsEnabledKey::class] ?: true
    set(value) {
        this[IsEnabledKey::class] = value
    }

private class IsHighlightedKey: UIEnvironmentKey

var UIEnvironment.isHighlighted: Boolean
    get() = this[IsHighlightedKey::class] ?: false
    set(value) {
        this[IsHighlightedKey::class] = value
    }
