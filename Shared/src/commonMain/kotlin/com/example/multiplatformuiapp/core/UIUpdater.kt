package com.example.multiplatformuiapp.core

import com.example.multiplatformuiapp.core.types.KotlinUIProviderContext

final class UIUpdater(
    private val provider: KotlinUIProvider,
    var ui: UI
) {

    private var isUpdating = false
    private var component: KotlinUIComponent? = null
    private var children: MutableMap<String, UIUpdater> = mutableMapOf()
    private var parent: UIUpdater? = null

    fun update(block: () -> Unit) {
        isUpdating = true
//        UIEnvironment.with(ui.mapUIEnvironment) {
//            block()
//            val context = KotlinUIProviderContext(ui.id, component)
//            val newComponent = component ?: ui.base.createComponent(provider, context)
//            component = newComponent
//            ui.base.update(newComponent, context)
//        }
        isUpdating = false
    }

    fun child(id: String): UIUpdater {
        val child = children[id] ?: UIUpdater(provider, ui)
        child.parent = this
        children[id] = child
        return child
    }

    companion object {

        private var currentUpdater: UIUpdater? = null

        val current: UIUpdater?
            get() = currentUpdater
    }
}
