package com.example.multiplatformuiapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform