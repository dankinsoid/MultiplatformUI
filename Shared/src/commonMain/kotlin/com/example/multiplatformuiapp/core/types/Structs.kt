package com.example.multiplatformuiapp.core.types

import com.example.multiplatformuiapp.core.KotlinUIComponent
import com.example.multiplatformuiapp.core.UIEnvironment

data class UISize(
    var width: Double = 0.0,
    var height: Double = 0.0
)

data class UIPoint(
    var x: Double = 0.0,
    var y: Double = 0.0
)

data class UIRect(
    var origin: UIPoint = UIPoint(),
    var size: UISize = UISize()
)

data class ProposedUISize(
    var width: Double? = null,
    var height: Double? = null
)

data class KotlinUIProviderContext(
    val id: String,
    val component: KotlinUIComponent?,
    val environment: UIEnvironment = UIEnvironment.current
)

data class KotlinUILayoutSubview(
    val id: String,
    val component: KotlinUIComponent,
    val frame: UIRect
)

data class Color(
    val red: Double,
    val green: Double,
    val blue: Double,
    val alpha: Double
)
