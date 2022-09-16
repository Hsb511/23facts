package com.team23.achievements.data.repositories

import com.team23.achievements.data.mappers.toModels
import com.team23.achievements.domain.models.AchievementModel
import com.team23.achievements.domain.repositories.AchievementRepository
import com.team23.room.data.daos.AchievementDao
import javax.inject.Inject

class AchievementRepositoryImpl @Inject constructor(
    private val achievementDao: AchievementDao
) : AchievementRepository {
    override suspend fun loadAll(): List<AchievementModel> = achievementDao.loadAll().toModels()

    override suspend fun unlockAchievement(achievementName: String) =
        achievementDao.updateIsFound(achievementName)
}