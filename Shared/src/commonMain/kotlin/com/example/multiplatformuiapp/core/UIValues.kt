package com.example.multiplatformuiapp.core

import kotlin.reflect.KClass

class UIValues {

    private val values: MutableMap<KClass<*>, Any> = mutableMapOf()

    operator fun <T, Key: UIValuesKey<T>> get(key: KClass<Key>): T? {
        return values[key] as? T
    }

    operator fun <T, Key: UIValuesKey<T>> set(key: KClass<Key>, value: T?) {
        if (value == null) {
            values.remove(key)
        } else {
            values[key] = value
        }
    }
}

interface UIValuesKey<T> {
}
