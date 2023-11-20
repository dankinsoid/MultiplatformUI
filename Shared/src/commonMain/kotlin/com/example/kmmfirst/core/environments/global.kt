package com.example.kmmfirst.core.environments

import com.example.kmmfirst.core.UIEnvironment
import com.example.kmmfirst.core.UIEnvironmentKey
import com.example.kmmfirst.core.types.Color

private class BackgroundColorKey: UIEnvironmentKey

var UIEnvironment.backgroundColor: Color
    get() = this[BackgroundColorKey()] ?: Color(0.0, 0.0, 0.0, 0.0)
    set(value) {
        this[BackgroundColorKey()] = value
    }

private class ForegroundColorKey: UIEnvironmentKey

var UIEnvironment.foregroundColor: Color
    get() = this[ForegroundColorKey()] ?: Color(0.0, 0.0, 0.0, 1.0)
    set(value) {
        this[ForegroundColorKey()] = value
    }

private class IsEnabledKey: UIEnvironmentKey

var UIEnvironment.isEnabled: Boolean
    get() = this[IsEnabledKey()] ?: true
    set(value) {
        this[IsEnabledKey()] = value
    }

private class IsHighlightedKey: UIEnvironmentKey

var UIEnvironment.isHighlighted: Boolean
    get() = this[IsHighlightedKey()] ?: false
    set(value) {
        this[IsHighlightedKey()] = value
    }
