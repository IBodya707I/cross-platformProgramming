package com.example.myapplicationlr6_10.di

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationlr6_10.data.about.AboutRepository
import com.example.myapplicationlr6_10.data.about.Platform
import com.example.myapplicationlr6_10.ui.about.AboutViewModel
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single
import org.koin.plugin.module.dsl.viewModel

val appModule = module {
    single<Platform>()
    single<AboutRepository>()
    viewModel<AboutViewModel>()
}