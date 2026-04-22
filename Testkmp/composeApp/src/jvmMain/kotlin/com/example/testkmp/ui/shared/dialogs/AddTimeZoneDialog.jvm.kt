package com.example.testkmp.ui.shared.dialogs

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogWindow
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.rememberDialogState
import testkmp.composeapp.generated.resources.Res
import testkmp.composeapp.generated.resources.add_timezones
import org.jetbrains.compose.resources.stringResource

@Composable
actual fun AddTimeDialogWrapper(
    onDismiss: () -> Unit,
    content: @Composable (() -> Unit)
) {

    DialogWindow(onCloseRequest = { onDismiss() },
        state = rememberDialogState(
            position = WindowPosition(Alignment.Center),
            size = DpSize(width = 400.dp, height = 400.dp),
        ),
        title = stringResource(Res.string.add_timezones),
        transparent = true,
        undecorated = true,
        content = {
            content()
        }
    )
}