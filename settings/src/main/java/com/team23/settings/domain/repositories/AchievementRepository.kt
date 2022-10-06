package com.team23.settings.domain.repositories

interface AchievementRepository {
    suspend fun resetAchievements()
}