package com.team23.achievements.domain.repositories

import com.team23.achievements.domain.models.AchievementModel
import java.util.*

interface AchievementRepository {
    suspend fun findIsFoundByName(name: String): Boolean
    suspend fun loadAll(): List<AchievementModel>
    suspend fun unlockAchievement(achievementName: String, date: Date)
}