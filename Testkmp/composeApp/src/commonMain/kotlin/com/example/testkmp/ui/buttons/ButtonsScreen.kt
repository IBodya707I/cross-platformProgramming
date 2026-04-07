package com.example.testkmp.ui.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import testkmp.composeapp.generated.resources.Res
import testkmp.composeapp.generated.resources.buttons
import org.jetbrains.compose.resources.stringResource

@Composable
fun ButtonsScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = stringResource(Res.string.buttons),
            style = MaterialTheme.typography.displayMedium)
    }
}