package com.example.myapplicationlr6_10.data.reminders

import com.example.myapplicationlr6_10.database.Task

internal data class Reminder (
    val id: Long,
    val title: String,
    val isCompleted: Boolean = false,
)

internal fun Task.map(): Reminder {
    return Reminder(
        id = id,
        title = task_desc,
        isCompleted = is_completed == 1L
    )
}