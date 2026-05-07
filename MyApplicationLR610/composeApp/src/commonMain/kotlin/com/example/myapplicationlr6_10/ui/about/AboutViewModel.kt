package com.example.myapplicationlr6_10.ui.about

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myapplicationlr6_10.data.about.AboutRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@Stable
internal class AboutViewModel(
    private val aboutRepository: AboutRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<List<Pair<String, String>>>(emptyList())
    val state = _state.asStateFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            val data = aboutRepository.getAbout()
            println("DEBUG: Дані завантажено! Кількість пунктів: ${data.size}")
            _state.value = aboutRepository.getAbout()
        }
    }
}

val aboutViewModelFactory = viewModelFactory {
    initializer {
        AboutViewModel(getAboutRepository())
    }
}

internal fun getAboutRepository(): AboutRepository = AboutRepository()