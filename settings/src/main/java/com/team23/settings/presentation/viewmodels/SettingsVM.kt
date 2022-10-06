package com.team23.settings.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class SettingsVM @AssistedInject constructor(
    @Assisted val changeStatusAndNavigationColors: () -> Unit,
) : ViewModel() {
    /**
     * True: Forced dark mode
     * False: Forced light mode
     * null: System setting
     */
    // TODO GET VALUE FROM DB
    val isDarkMode: MutableState<Boolean> = mutableStateOf(false)
    val themeModeSelectedValue: MutableState<Int> = mutableStateOf(1)

    fun onThemeModeChanged() {
        changeStatusAndNavigationColors()
    }

    fun onLanguageChanged(value : Int) {
        // TODO
    }

    fun onResetData() {

    }

    @AssistedFactory
    interface Factory {
        fun create(changeStatusAndNavigationColors: () -> Unit): SettingsVM
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            changeStatusAndNavigationColors: () -> Unit,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return assistedFactory.create(changeStatusAndNavigationColors) as T
            }
        }
    }
}