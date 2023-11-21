package com.example.multiplatformuiapp.core.types

enum class Axis {
    HORIZONTAL,
    VERTICAL;
}

operator fun UISize.get(axis: Axis): Double = when (axis) {
    Axis.HORIZONTAL -> width
    Axis.VERTICAL -> height
}

operator fun UISize.set(axis: Axis, value: Double) {
    when (axis) {
        Axis.HORIZONTAL -> width = value
        Axis.VERTICAL -> height = value
    }
}

operator fun UIPoint.get(axis: Axis): Double = when (axis) {
    Axis.HORIZONTAL -> x
    Axis.VERTICAL -> y
}

operator fun UIPoint.set(axis: Axis, value: Double) {
    when (axis) {
        Axis.HORIZONTAL -> x = value
        Axis.VERTICAL -> y = value
    }
}

operator fun ProposedUISize.get(axis: Axis): Double? = when (axis) {
    Axis.HORIZONTAL -> width
    Axis.VERTICAL -> height
}

operator fun ProposedUISize.set(axis: Axis, value: Double?) {
    when (axis) {
        Axis.HORIZONTAL -> width = value
        Axis.VERTICAL -> height = value
    }
}

var Axis.opposite: Axis
    get() = when (this) {
        Axis.HORIZONTAL -> Axis.VERTICAL
        Axis.VERTICAL -> Axis.HORIZONTAL
    }
    set(value) {
        when (value) {
            Axis.HORIZONTAL -> Axis.VERTICAL
            Axis.VERTICAL -> Axis.HORIZONTAL
        }
    }

fun Axis.proposalSize(main: Double?, cross: Double?): ProposedUISize = when (this) {
    Axis.HORIZONTAL -> ProposedUISize(main, cross)
    Axis.VERTICAL -> ProposedUISize(cross, main)
}

fun Axis.size(main: Double, cross: Double): UISize = when (this) {
    Axis.HORIZONTAL -> UISize(main, cross)
    Axis.VERTICAL -> UISize(cross, main)
}
