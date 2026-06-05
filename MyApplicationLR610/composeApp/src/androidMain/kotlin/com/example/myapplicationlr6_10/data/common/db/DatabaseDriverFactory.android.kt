package com.example.myapplicationlr6_10.data.common.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.myapplicationlr6_10.database.Organise
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class DatabaseDriverFactory : KoinComponent {
    private val context: Context by inject()

    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(Organise.Schema, context, "organise.db")
    }
}