package com.team23.settings.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.team23.settings.domain.usecases.ResetDatabaseUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsVM @AssistedInject constructor(
    @Assisted("changeStatusAndNavigationColors") val changeStatusAndNavigationColors: () -> Unit,
    @Assisted("resetAchievementData") val resetAchievementData: () -> Unit,
    private val resetDatabaseUseCase: ResetDatabaseUseCase,
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

    fun onLanguageChanged(value: Int) {
        // TODO
    }

    fun onResetData() {
        resetAchievementData()
        viewModelScope.launch(Dispatchers.IO) {
            resetDatabaseUseCase()
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("changeStatusAndNavigationColors") changeStatusAndNavigationColors: () -> Unit,
            @Assisted("resetAchievementData") resetAchievementData: () -> Unit
        ): SettingsVM
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            changeStatusAndNavigationColors: () -> Unit,
            resetAchievementData: () -> Unit,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return assistedFactory.create(
                    changeStatusAndNavigationColors,
                    resetAchievementData
                ) as T
            }
        }
    }
}