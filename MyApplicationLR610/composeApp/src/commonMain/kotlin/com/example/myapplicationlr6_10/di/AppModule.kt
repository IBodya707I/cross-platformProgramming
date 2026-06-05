package com.example.myapplicationlr6_10.di

import com.example.myapplicationlr6_10.data.about.AboutRepository
import com.example.myapplicationlr6_10.data.about.Platform
import com.example.myapplicationlr6_10.data.common.db.DatabaseDriverFactory
import com.example.myapplicationlr6_10.data.common.db.DbDataSource
import com.example.myapplicationlr6_10.data.common.db.LocalDataSource
import com.example.myapplicationlr6_10.data.common.preferences.AppPreferences
import com.example.myapplicationlr6_10.data.common.preferences.Preferences
import com.example.myapplicationlr6_10.data.reminders.RemindersRepository
import com.example.myapplicationlr6_10.database.Organise
import com.example.myapplicationlr6_10.ui.about.AboutViewModel
import com.example.myapplicationlr6_10.ui.reminders.ReminderViewModel
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module


private fun createSettings() : Settings = Settings()

private fun createDb(driver: DatabaseDriverFactory) : Organise = Organise(driver.create())


val dataModule = module {
    single<Settings> { createSettings() }
    single<ObservableSettings> { get<Settings>() as ObservableSettings }
    single<Preferences> { AppPreferences(get(), get()) }
    singleOf(::DatabaseDriverFactory)
    single { createDb(get()) }
    singleOf(::DbDataSource) bind LocalDataSource::class
}

val appModule = module {
    includes(dataModule)
    single { Platform() }
    singleOf(::AboutRepository)
    singleOf(::RemindersRepository)
    viewModelOf(::AboutViewModel)
    viewModelOf(::ReminderViewModel)
}