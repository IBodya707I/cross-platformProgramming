package com.example.testkmp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.testkmp.ui.shared_mobile.main.MainScreen
import com.example.testkmp.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource
import testkmp.composeapp.generated.resources.Res
import testkmp.composeapp.generated.resources.find_meeting
import testkmp.composeapp.generated.resources.world_clocks

@OptIn(ExperimentalMaterial3Api::class)
fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Testkmp",
    ) {
        AppTheme {
            MainScreen {
                TopAppBar(
                    title = {
                        when (it) {
                            0 -> Text(text = stringResource(Res.string.world_clocks))
                            else -> Text(text = stringResource(Res.string.find_meeting))
                        }
                    }
                )
            }
        }
    }
}