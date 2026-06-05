package com.example.myapplicationlr6_10.data.common.db

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory() {
    fun create(): SqlDriver
}