package com.example.myapplicationlr6_10

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyApplicationLR610",
    ) {
        App()
    }
}