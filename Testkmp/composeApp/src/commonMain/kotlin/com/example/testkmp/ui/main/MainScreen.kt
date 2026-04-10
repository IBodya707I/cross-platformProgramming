package com.example.testkmp.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import testkmp.composeapp.generated.resources.Res
import testkmp.composeapp.generated.resources.buttons
import org.jetbrains.compose.resources.stringResource
import testkmp.composeapp.generated.resources.checkboxes
import testkmp.composeapp.generated.resources.chips
import testkmp.composeapp.generated.resources.date_pickers
import testkmp.composeapp.generated.resources.dialogs
import testkmp.composeapp.generated.resources.dividers
import testkmp.composeapp.generated.resources.progressbars
import testkmp.composeapp.generated.resources.radiobuttons
import testkmp.composeapp.generated.resources.switchs
import testkmp.composeapp.generated.resources.timepickers

@Composable
fun MainScreen(
    onButtonsClicked: () -> Unit = {},
    onCheckboxesClicked: () -> Unit = {},
    onChipsClicked: () -> Unit = {},
    onDatePickersClicked: () -> Unit = {},
    onDialogsClicked: () -> Unit = {},
    onDividersClicked: () -> Unit = {},
    onProgressBarsClicked: () -> Unit = {},
    onRadioButtonsClicked: () -> Unit = {},
    onSwitchsClicked: () -> Unit = {},
    onTimePickersClicked: () -> Unit = {},
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onButtonsClicked()

            }
        ) {
            Text(stringResource(Res.string.buttons)
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick =  {
                onCheckboxesClicked()
        }
        ) {
            Text(stringResource(Res.string.checkboxes))
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            onChipsClicked()
        }){
            Text((stringResource(Res.string.chips)))
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            onDatePickersClicked()
        }){
            Text((stringResource(Res.string.date_pickers)))
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            onDialogsClicked()
        }){
            Text((stringResource(Res.string.dialogs)))
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            onDividersClicked()
        }){
            Text((stringResource(Res.string.dividers)))
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            onProgressBarsClicked()
        }){
            Text((stringResource(Res.string.progressbars)))
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            onRadioButtonsClicked()
        }){
            Text((stringResource(Res.string.radiobuttons)))
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            onSwitchsClicked()
        }){
            Text((stringResource(Res.string.switchs)))
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            onTimePickersClicked()
        }){
            Text((stringResource(Res.string.timepickers)))
        }

    }
}