package com.team23.settings.data.repositories

import com.team23.room.data.daos.AchievementDao
import com.team23.settings.domain.repositories.AchievementRepository
import javax.inject.Inject

class AchievementRoomRepository @Inject constructor(
    private val achievementDao: AchievementDao
) : AchievementRepository {
    override suspend fun resetAchievements() {
        achievementDao.resetData()
    }
}