package com.example.kmmfirst.core

class UIEnvironment {

    private val values: MutableMap<String, Any> = mutableMapOf()
    private var parent: UIEnvironment? = null

    operator fun <T: Any> get(key: UIEnvironmentKey): T? {
        return values[key.name] as? T ?: parent?.get(key)
    }

    operator fun <T: Any> set(key: UIEnvironmentKey, value: T?) {
        if (value == null) {
            values.remove(key.name)
        } else {
            values[key.name] = value
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

interface UIEnvironmentKey {
}

private val UIEnvironmentKey.name: String
    get() = this::class.qualifiedName ?: "${this::class}"

