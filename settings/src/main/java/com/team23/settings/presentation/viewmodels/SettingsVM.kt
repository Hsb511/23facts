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
import com.team23.settings.domain.models.RandomnessType
import com.team23.settings.domain.models.ThemeMode
import com.team23.settings.domain.usecases.GetStoredSettingsValueUseCase
import com.team23.settings.domain.usecases.ResetDatabaseUseCase
import com.team23.settings.domain.usecases.StoreRandomnessUseCase
import com.team23.settings.presentation.viewobjects.SettingsSingleChoiceVO
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsVM @AssistedInject constructor(
    @Assisted("changeStatusAndNavigationColors") val changeStatusAndNavigationColors: () -> Unit,
    @Assisted("resetAchievementData") val resetAchievementData: () -> Unit,
    private val getStoredSettingsValueUseCase: GetStoredSettingsValueUseCase,
    private val resetDatabaseUseCase: ResetDatabaseUseCase,
    private val storeRandomnessUseCase: StoreRandomnessUseCase,
) : ViewModel() {
    val isDarkMode: MutableState<Boolean?> = mutableStateOf(null)
    private val storedThemeMode: MutableState<Int> = mutableStateOf(1)
    private val storedRandomnessType: MutableState<Int> = mutableStateOf(0)
    val settingsSingleChoiceList = mutableStateListOf<SettingsSingleChoiceVO>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            with(getStoredSettingsValueUseCase()) {
                storedThemeMode.value = this[0]
                storedRandomnessType.value = this[2]
            }
        }
        settingsSingleChoiceList.addAll(
            listOf(
                SettingsSingleChoiceVO(
                    titleId = R.string.settings_theme_mode,
                    values = ThemeMode.values().map { it.displayName },
                    onValueChanged = {
                        storedThemeMode.value = it
                        isDarkMode.value = when (storedThemeMode.value) {
                            0 -> true
                            2 -> false
                            else -> null
                        }
                        changeStatusAndNavigationColors()
                    },
                    selectedValue = storedThemeMode,
                ),
                SettingsSingleChoiceVO(
                    titleId = R.string.settings_colors,
                    values = listOf(
                        R.string.settings_colors_app,
                        R.string.settings_colors_custom,
                    ),
                    // TODO HANDLE MATERIAL YOU COLOR
                    onValueChanged = { },
                    selectedValue = mutableStateOf(0),
                    disabled = true,
                    displayed = Build.VERSION.SDK_INT >= 31,
                ),
                SettingsSingleChoiceVO(
                    titleId = R.string.settings_random,
                    values = RandomnessType.values().map { it.displayName },
                    onValueChanged = {
                        viewModelScope.launch(Dispatchers.IO) {
                            storeRandomnessUseCase(RandomnessType.values()[it])
                            storedRandomnessType.value = it
                        }
                     },
                    selectedValue = storedRandomnessType,
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