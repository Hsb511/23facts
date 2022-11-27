package com.team23.settings.data.mappers

import com.team23.room.data.entities.SettingEntity
import com.team23.settings.domain.models.SettingsModel
import javax.inject.Inject

class SettingsMapper @Inject constructor() {
    fun toDomainModels(settingsEntities: List<SettingEntity>): List<SettingsModel> =
        settingsEntities.map { toDomainModel(it) }

    private fun toDomainModel(settingsEntity: SettingEntity): SettingsModel = SettingsModel(
        id = settingsEntity.id,
        value = settingsEntity.value
    )
}