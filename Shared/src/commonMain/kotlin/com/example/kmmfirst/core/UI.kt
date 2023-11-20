package com.example.kmmfirst.core

data class UI(
    var id: String,
    var base: BaseComponent,
    var mapUIEnvironment: (UIEnvironment) -> Unit
) {

    val environment: UIEnvironment
        get() = UIEnvironment.current.map(mapUIEnvironment)
}
