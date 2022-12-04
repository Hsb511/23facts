package com.team23.settings.domain.repositories

import com.team23.settings.domain.models.SettingsModel

interface SettingRepository {
    suspend fun insertOrUpdateRandomness(newValue: String)
    suspend fun insertOrUpdateThemeMode(newValue: String)
    suspend fun getAllStoredValues(): List<SettingsModel>
}