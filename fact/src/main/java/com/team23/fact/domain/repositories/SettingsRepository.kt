package com.team23.fact.domain.repositories

interface SettingsRepository {
    suspend fun getRandomnessSetting(): String?
}