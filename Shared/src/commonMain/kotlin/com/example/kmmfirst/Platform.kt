package com.example.kmmfirst

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform