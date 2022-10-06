package com.team23.settings.domain.repositories

interface FactRepository {
    suspend fun resetFacts()
}