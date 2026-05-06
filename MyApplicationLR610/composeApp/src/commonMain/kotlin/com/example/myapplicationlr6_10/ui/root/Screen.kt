package com.example.myapplicationlr6_10.ui.root

sealed class Screen(val route: String) {
    object Reminders : Screen("reminders")
    object AboutDevice : Screen("about")
}
