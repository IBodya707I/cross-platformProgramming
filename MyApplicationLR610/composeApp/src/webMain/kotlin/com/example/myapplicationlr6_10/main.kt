package com.example.myapplicationlr6_10

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.example.myapplicationlr6_10.ui.root.AppScaffold
import com.example.myapplicationlr6_10.ui.theme.AppTheme

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport {
        AppTheme {
            AppScaffold()
        }
    }
}