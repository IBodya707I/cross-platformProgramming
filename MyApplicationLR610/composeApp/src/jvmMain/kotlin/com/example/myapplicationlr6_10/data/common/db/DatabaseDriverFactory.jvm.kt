package com.example.myapplicationlr6_10.data.common.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import com.example.myapplicationlr6_10.database.Organise
import java.io.File

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class DatabaseDriverFactory {

    actual fun create(): SqlDriver {
        val dbPath = "${System.getProperty("user.home")}/.organise/organise.db"
        File(dbPath).parentFile?.mkdirs()
        val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:$dbPath")
        if (!File(dbPath).exists()) {
            Organise.Schema.create(driver)
        }
        return driver
    }
}