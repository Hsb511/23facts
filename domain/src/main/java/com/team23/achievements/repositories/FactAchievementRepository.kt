package com.team23.achievements.repositories

interface FactAchievementRepository {
    suspend fun countReadFacts(): Int
}