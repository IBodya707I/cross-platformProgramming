package com.example.myapplicationlr6_10

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.myapplicationlr6_10.ui.root.AppScaffold
import com.example.myapplicationlr6_10.ui.theme.AppTheme

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MyApplicationLR610",
    ) {
        AppTheme {
            AppScaffold()
        }
    }
}