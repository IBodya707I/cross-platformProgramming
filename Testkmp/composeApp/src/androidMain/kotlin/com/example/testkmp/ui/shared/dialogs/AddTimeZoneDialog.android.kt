package com.example.testkmp.ui.shared.dialogs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog

@Composable
actual fun AddTimeDialogWrapper(
    onDismiss: () -> Unit,
    content: @Composable (() -> Unit)
) {
    Dialog(onDismissRequest = onDismiss) {
        Box(modifier = Modifier.fillMaxHeight(0.6f)) {
            content()
        }
    }
}