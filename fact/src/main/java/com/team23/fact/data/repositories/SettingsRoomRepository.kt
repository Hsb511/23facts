package com.team23.fact.data.repositories

import com.team23.fact.domain.repositories.SettingsRepository
import com.team23.room.data.daos.SettingDao
import com.team23.room.data.entities.SettingsName
import javax.inject.Inject

class SettingsRoomRepository @Inject constructor(
    private val settingDao: SettingDao
) : SettingsRepository {
    override suspend fun getRandomnessSetting(): String? =
        settingDao.findValueByName(SettingsName.RANDOMNESS.name)

}