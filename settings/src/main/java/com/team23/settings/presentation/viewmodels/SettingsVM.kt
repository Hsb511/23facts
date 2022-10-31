package com.team23.settings.presentation.viewmodels

import android.os.Build
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.team23.settings.R
import com.team23.settings.domain.usecases.ResetDatabaseUseCase
import com.team23.settings.presentation.viewobjects.SettingsSingleChoiceVO
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
    // TODO GET VALUE FROM DB
    val isDarkMode: MutableState<Boolean?> = mutableStateOf(null)
    private val themeModeSelectedValue: MutableState<Int> = mutableStateOf(1)
    val settingsSingleChoiceList = mutableStateListOf<SettingsSingleChoiceVO>()

    init {
        settingsSingleChoiceList.addAll(
            listOf(
                SettingsSingleChoiceVO(
                    titleId = R.string.settings_theme_mode,
                    values = listOf(
                        R.string.settings_forced_dark_mode,
                        R.string.settings_system_mode,
                        R.string.settings_forced_light_mode,
                    ),
                    onValueChanged = {
                        themeModeSelectedValue.value = it
                        isDarkMode.value = when (themeModeSelectedValue.value) {
                            0 -> true
                            2 -> false
                            else -> null
                        }
                        changeStatusAndNavigationColors()
                    },
                    lastSelectedValue = 1,
                ),
                SettingsSingleChoiceVO(
                    titleId = R.string.settings_colors,
                    values = listOf(
                        R.string.settings_colors_app,
                        R.string.settings_colors_custom,
                    ),
                    // TODO HANDLE MATERIAL YOU COLOR
                    onValueChanged = { },
                    lastSelectedValue = 0,
                    disabled = true,
                    displayed = Build.VERSION.SDK_INT >= 31,
                ),
                SettingsSingleChoiceVO(
                    titleId = R.string.settings_random,
                    values = listOf(
                        R.string.settings_random_pure,
                        R.string.settings_random_unread,
                    ),
                    // TODO HANDLE RANDOMNESS
                    onValueChanged = { },
                    lastSelectedValue = 0,
                    disabled = true
                )
            )
        )

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