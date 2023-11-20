package com.example.miltiplatformuiapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform