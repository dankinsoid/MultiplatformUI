package com.example.multiplatformuiapp.core.values

import com.example.multiplatformuiapp.core.UI
import com.example.multiplatformuiapp.core.UIValues
import com.example.multiplatformuiapp.core.UIValuesKey
import com.example.multiplatformuiapp.core.types.UIPoint
import com.example.multiplatformuiapp.core.types.UISize

private class OpacityKey: UIValuesKey<Double>

var UIValues.opacity: Double
    get() = this[OpacityKey::class] ?: 1.0
    set(value) {
        this[OpacityKey::class] = value
    }


private class TranslationKey: UIValuesKey<UIPoint>
var UIValues.offset: UIPoint
    get() = this[TranslationKey::class] ?: UIPoint(0.0, 0.0)
    set(value) {
        this[TranslationKey::class] = value
    }

fun UI.offset(offset: UIPoint): UI = values {
    it.offset.x += offset.x
    it.offset.y += offset.y
}

fun UI.offset(x: Double = 0.0, y: Double = 0.0): UI = offset(UIPoint(x, y))

private class ScaleKey: UIValuesKey<UISize>

var UIValues.scale: UISize
    get() = this[ScaleKey::class] ?: UISize(1.0, 1.0)
    set(value) {
        this[ScaleKey::class] = value
    }

fun UI.scale(scale: UISize): UI = values {
    it.scale.width *= scale.width
    it.scale.height *= scale.height
}

fun UI.scale(scale: Double): UI = scale(UISize(scale, scale))

fun UI.scale(width: Double = 1.0, height: Double = 1.0): UI = scale(UISize(width, height))

private class RotationKey: UIValuesKey<Double>

var UIValues.rotation: Double
    get() = this[RotationKey::class] ?: 0.0
    set(value) {
        this[RotationKey::class] = value
    }

fun UI.rotate(degrees: Double): UI = values {
    it.rotation += degrees
}

internal val UIValues.isRequireComponent: Boolean
    get() = opacity != 1.0 || offset != UIPoint(0.0, 0.0) || scale != UISize(1.0, 1.0) || rotation != 0.0