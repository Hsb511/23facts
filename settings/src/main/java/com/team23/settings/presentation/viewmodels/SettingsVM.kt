package com.team23.settings.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsVM @Inject constructor() : ViewModel() {
    /**
     * True: Forced dark mode
     * False: Forced light mode
     * null: System setting
     */
    val isForcedDarkMode: MutableState<Boolean?> = mutableStateOf(null)

    fun onThemeModeChanged(selectedPosition: Int) {
        when(selectedPosition) {
            0 -> isForcedDarkMode.value = true
            1 -> isForcedDarkMode.value = null
            2 -> isForcedDarkMode.value = false
            else -> isForcedDarkMode.value = null
        }
    }
}