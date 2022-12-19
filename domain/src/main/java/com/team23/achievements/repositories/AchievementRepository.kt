package com.team23.achievements.repositories

import com.team23.achievements.models.AchievementModel
import java.util.Date

interface AchievementRepository {
    suspend fun findIsFoundByName(name: String): Boolean
    suspend fun loadAll(): List<AchievementModel>
    suspend fun unlockAchievement(achievementName: String, date: Date)
}