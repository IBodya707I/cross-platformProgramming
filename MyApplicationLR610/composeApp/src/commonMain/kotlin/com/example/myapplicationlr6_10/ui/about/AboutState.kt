package com.example.myapplicationlr6_10.ui.about

internal data class AboutState(
    val platformInfo: List<Pair<String, String>> = emptyList(),
    val visitedCount: Int = 0,
    val visitedDate: String = ""
)