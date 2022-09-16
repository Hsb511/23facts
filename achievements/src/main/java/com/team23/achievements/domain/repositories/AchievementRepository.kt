package com.team23.achievements.domain.repositories

import com.team23.achievements.domain.models.AchievementModel

interface AchievementRepository {
    suspend fun findIsFoundByName(name: String): Boolean
    suspend fun loadAll(): List<AchievementModel>
    suspend fun unlockAchievement(achievementName: String)
}