package com.example.myapplicationlr6_10.di

import com.example.myapplicationlr6_10.data.about.AboutRepository
import com.example.myapplicationlr6_10.data.about.Platform
import com.example.myapplicationlr6_10.data.common.preferences.AppPreferences
import com.example.myapplicationlr6_10.data.common.preferences.Preferences
import com.example.myapplicationlr6_10.ui.about.AboutViewModel
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module


private fun createSettings() : Settings = Settings()

val dataModule = module {
    single<Settings> { createSettings() }
    single<ObservableSettings> { get<Settings>() as ObservableSettings }
    single<Preferences> { AppPreferences(get(), get()) }
}

val appModule = module {
    includes(dataModule)
    singleOf(::Platform)
    singleOf(::AboutRepository)
    viewModelOf(::AboutViewModel)
}