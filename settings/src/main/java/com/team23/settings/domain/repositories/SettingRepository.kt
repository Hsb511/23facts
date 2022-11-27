package com.team23.settings.domain.repositories

import com.team23.settings.domain.models.SettingsModel

interface SettingRepository {
    suspend fun updateRandomSetting(newValue: String)
    suspend fun getAllStoredValues(): List<SettingsModel>
}