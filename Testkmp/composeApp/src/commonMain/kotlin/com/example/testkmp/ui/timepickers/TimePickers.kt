package com.example.testkmp.ui.timepickers

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun TimePickers() {
    var selectedTime by remember { mutableStateOf("Час не обрано") }
    var showDialDialog by remember { mutableStateOf(false) }
    var showInputDialog by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Обраний час: $selectedTime",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(onClick = { showDialDialog = true }) {
            Text("Вибрати час (Годинник)")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showInputDialog = true }) {
            Text("Вибрати час (Цифри)")
        }
    }

    if (showDialDialog) {
        DialExampleDialog(
            onConfirm = { hour, minute ->
                selectedTime = "$hour:${minute.toString().padStart(2, '0')}"
                showDialDialog = false
            },
            onDismiss = { showDialDialog = false }
        )
    }

    if (showInputDialog) {
        InputExampleDialog(
            onConfirm = { hour, minute ->
                selectedTime = "$hour:${minute.toString().padStart(2, '0')}"
                showInputDialog = false
            },
            onDismiss = { showInputDialog = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialExampleDialog(
    onConfirm: (Int, Int) -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = kotlin.time.Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.hour,
        initialMinute = currentTime.minute,
        is24Hour = true,
    )

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surfaceContainerHigh,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TimePicker(
                    state = timePickerState,
                    layoutType = TimePickerLayoutType.Vertical
                )
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Скасувати")
                    }
                    TextButton(onClick = { onConfirm(timePickerState.hour, timePickerState.minute) }) {
                        Text("OK")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputExampleDialog(
    onConfirm: (Int, Int) -> Unit,
    onDismiss: () -> Unit,
) {
    val currentTime = kotlin.time.Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.hour,
        initialMinute = currentTime.minute,
        is24Hour = true,
    )

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surfaceContainerHigh,
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TimeInput(state = timePickerState)
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Скасувати")
                    }
                    TextButton(onClick = { onConfirm(timePickerState.hour, timePickerState.minute) }) {
                        Text("OK")
                    }
                }
            }
        }
    }
}
