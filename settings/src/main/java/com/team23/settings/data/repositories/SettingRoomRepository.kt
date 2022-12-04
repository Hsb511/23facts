package com.team23.settings.data.repositories

import com.team23.room.data.daos.SettingDao
import com.team23.room.data.entities.SettingEntity
import com.team23.room.data.entities.SettingsName
import com.team23.settings.data.mappers.SettingsMapper
import com.team23.settings.domain.models.SettingsModel
import com.team23.settings.domain.repositories.SettingRepository
import javax.inject.Inject

class SettingRoomRepository @Inject constructor(
    private val settingDao: SettingDao,
    private val settingsMapper: SettingsMapper,
) : SettingRepository {
    override suspend fun insertOrUpdateRandomness(newValue: String) {
        settingDao.insertOrUpdateSetting(createSettingEntity(SettingsName.RANDOMNESS, newValue))
    }

    override suspend fun insertOrUpdateThemeMode(newValue: String) {
        settingDao.insertOrUpdateSetting(createSettingEntity(SettingsName.THEME, newValue))
    }

    override suspend fun getAllStoredValues(): List<SettingsModel> =
        settingsMapper.toDomainModels(settingDao.findAllValuesOrderedById())

    private fun createSettingEntity(setting: SettingsName, value: String) = SettingEntity(
        id = setting.ordinal.toLong(),
        name = setting.name,
        value = value
    )
}