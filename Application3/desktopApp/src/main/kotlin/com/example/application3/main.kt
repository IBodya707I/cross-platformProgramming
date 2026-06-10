package com.example.application3

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.application3.di.initKoin
import com.example.application3.presentation.App

fun main() = application {
    initKoin { printLogger() }
    Window(
        onCloseRequest = ::exitApplication,
        title = "Application3",
    ) {
        App()
    }
}