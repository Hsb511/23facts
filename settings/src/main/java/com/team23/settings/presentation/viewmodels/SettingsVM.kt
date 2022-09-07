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

    val sliderValue: MutableState<Float> = mutableStateOf(0f)
}