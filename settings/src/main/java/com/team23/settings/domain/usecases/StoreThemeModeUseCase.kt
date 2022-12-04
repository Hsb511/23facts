package com.team23.settings.domain.usecases

import com.team23.settings.domain.models.ThemeMode
import com.team23.settings.domain.repositories.SettingRepository
import javax.inject.Inject

class StoreThemeModeUseCase @Inject constructor(
    private val settingRepository: SettingRepository
) {
    suspend fun invoke(theme: ThemeMode) {
        settingRepository.insertOrUpdateThemeMode(theme.name)
    }
}