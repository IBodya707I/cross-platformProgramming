package com.example.myapplicationlr6_10.data.common.db

import com.example.myapplicationlr6_10.database.Task
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun insertTask(description: String)

    fun getAllTasks(): List<Task>

    fun markTaskCompleted(id: Long)

    fun markTaskPending(id: Long)

    fun deleteTask(id: Long)
}