package com.example.multiplatformuiapp.core

import kotlin.reflect.KClass

class UIEnvironment {

    private val values: MutableMap<KClass<*>, Any> = mutableMapOf()
    private var parent: UIEnvironment? = null

    operator fun <T, Key: UIEnvironmentKey<T>> get(key: KClass<Key>): T? {
        return values[key] as? T ?: parent?.get(key)
    }

    operator fun <T, Key: UIEnvironmentKey<T>> set(key: KClass<Key>, value: T?) {
        if (value == null) {
            values.remove(key)
        } else {
            values[key] = value
        }
    }

    fun map(modify: (UIEnvironment) -> Unit): UIEnvironment {
        val result = UIEnvironment()
        result.parent = this
        modify(result)
        return result
    }

    companion object {

        private var currentEnvironment: UIEnvironment = UIEnvironment()
        val current: UIEnvironment
            get() = currentEnvironment

        fun <T> with(modify: (UIEnvironment) -> Unit, action: () -> T): T {
            val environment = currentEnvironment.map(modify)
            val oldEnvironment = currentEnvironment
            currentEnvironment = environment
            val result = action()
            currentEnvironment = oldEnvironment
            return result
        }
    }
}

interface UIEnvironmentKey<T> {
}
