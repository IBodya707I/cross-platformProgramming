package com.example.testkmp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testkmp.App
import testkmp.composeapp.generated.resources.*
import org.jetbrains.compose.resources.StringResource
import com.example.testkmp.ui.buttons.ButtonsScreen
import com.example.testkmp.ui.checkboxes.CheckboxesScreen
import com.example.testkmp.ui.chips.ChipsScreen
import com.example.testkmp.ui.datepickers.DatePickersScreen
import com.example.testkmp.ui.dialogs.DialogScreen
import com.example.testkmp.ui.dividers.DividersScreen
import com.example.testkmp.ui.main.MainScreen
import com.example.testkmp.ui.progressbars.ProgressBarsScreen
import com.example.testkmp.ui.radiobuttons.RadioButtonsScreen
import com.example.testkmp.ui.switchs.SwitchsScreen
import com.example.testkmp.ui.timepickers.TimePickersScreen
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

enum class AppScreen(val title: StringResource) {
    Main(title = Res.string.main),
    Buttons(title = Res.string.buttons),
    Checkboxes(title = Res.string.checkboxes),
    Chips(title = Res.string.chips),
    DatePickers(title = Res.string.date_pickers),
    Dialogs(title = Res.string.dialogs),
    Dividers(title = Res.string.dividers),
    ProgressBars(title = Res.string.progressbars),
    RadioButtons(title = Res.string.radiobuttons),
    Switchs(title = Res.string.switchs),
    TimePickers(title = Res.string.timepickers)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    currentScreen: AppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(Res.string.back)
                    )
                }
            }
        })
}

@Composable
fun AppNavigation() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = AppScreen.valueOf(
        backStackEntry?.destination?.route ?: AppScreen.Main.name
    )

    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            AppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreen.Main.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            composable(route = AppScreen.Main.name) {
                MainScreen(
                    onButtonsClicked = {navController.navigate(AppScreen.Buttons.name)},
                    onCheckboxesClicked = {navController.navigate(AppScreen.Checkboxes.name)},
                    onChipsClicked = {navController.navigate(AppScreen.Chips.name)},
                    onDatePickersClicked = {navController.navigate(AppScreen.DatePickers.name)},
                    onDialogsClicked = {navController.navigate(AppScreen.Dialogs.name)},
                    onDividersClicked = {navController.navigate(AppScreen.Dividers.name)},
                    onProgressBarsClicked = {navController.navigate(AppScreen.ProgressBars.name)},
                    onRadioButtonsClicked = {navController.navigate(AppScreen.RadioButtons.name)},
                    onSwitchsClicked = {navController.navigate(AppScreen.Switchs.name)},
                    onTimePickersClicked = {navController.navigate(AppScreen.TimePickers.name)},
                )
            }
            composable(route = AppScreen.Buttons.name) {
                ButtonsScreen(
                    onFilledButtonClicked = { text ->
                        scope.launch {
                            snackbarHostState
                                .showSnackbar(
                                    message = text,
                                    duration = SnackbarDuration.Short
                                )
                        }
                    }
                )
            }
            composable(route = AppScreen.Checkboxes.name) {
                CheckboxesScreen()
            }
            composable(route = AppScreen.Chips.name) {
                ChipsScreen()
            }
            composable(route = AppScreen.DatePickers.name) {
                DatePickersScreen()
            }
            composable(route = AppScreen.Dialogs.name) {
                DialogScreen()
            }
            composable(route = AppScreen.Dividers.name) {
                DividersScreen()
            }
            composable(route = AppScreen.ProgressBars.name) {
                ProgressBarsScreen()
            }
            composable(route = AppScreen.RadioButtons.name) {
                RadioButtonsScreen()
            }
            composable(route = AppScreen.Switchs.name){
                SwitchsScreen()
            }
            composable(route = AppScreen.TimePickers.name) {
                TimePickersScreen()
            }
        }
    }
}