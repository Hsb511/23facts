package com.team23.achievements.data.repositories

import com.team23.achievements.data.mappers.toListModel
import com.team23.achievements.models.AchievementModel
import com.team23.achievements.repositories.AchievementRepository
import com.team23.room.data.daos.AchievementDao
import java.util.*
import javax.inject.Inject

internal class AchievementRepositoryImpl @Inject constructor(
    private val achievementDao: AchievementDao
) : AchievementRepository {
    override suspend fun findIsFoundByName(name: String): Boolean =
        achievementDao.findIsFoundByName(name)

    override suspend fun loadAll(): List<AchievementModel> = achievementDao.loadAll().toListModel()

    override suspend fun unlockAchievement(achievementName: String, date: Date) =
        achievementDao.updateIsFoundAndUnlockDate(achievementName, date)
}