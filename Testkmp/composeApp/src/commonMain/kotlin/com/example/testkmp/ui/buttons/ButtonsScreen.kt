package com.example.testkmp.ui.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testkmp.ui.theme.AppTheme
import com.example.testkmp.ui.theme.getTypography

@Composable
fun ButtonsScreen(onFilledButtonClicked: (text: String) -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = {
                onFilledButtonClicked.invoke(("Filled"))
            }
        ) {
            Text("Filled")
        }

        FilledTonalButton(
            onClick = {
                onFilledButtonClicked.invoke(("Filled tonal"))
            }
        ) {
            Text("Filled tonal")
        }

        OutlinedButton(onClick = {
                onFilledButtonClicked.invoke("OutLined")
        }) {
            Text("Outlined")
        }

        ElevatedButton(onClick = {
                onFilledButtonClicked.invoke("Elevated")
        }) {
            Text("Elevated")
        }

        TextButton(
            onClick = {
                onFilledButtonClicked("Text")
            }
        ) {
            Text("Text Button")
        }

        Button(
            onClick = {
                onFilledButtonClicked("Filled with icon")
            }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Filled with icon"
                )
                Icon(Icons.Filled.Done, "Floating action button.")
            }
        }
        FloatingActionButton(
            onClick = {
                onFilledButtonClicked.invoke("Floating")
            },
        ) {
            Icon(Icons.Filled.Call, "Floating action button.")
        }
    }
}