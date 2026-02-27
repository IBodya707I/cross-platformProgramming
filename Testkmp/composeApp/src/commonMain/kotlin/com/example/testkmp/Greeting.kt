package com.example.testkmp

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello world from ${platform.name}!"
    }
}