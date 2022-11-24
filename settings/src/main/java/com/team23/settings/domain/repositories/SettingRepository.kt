package com.team23.settings.domain.repositories

interface SettingRepository {
    suspend fun updateRandomSetting(newValue: String)
    suspend fun getAllStoredValues(): List<String>
}