package com.team23.achievements.domain.repositories

interface FactRepository {
    suspend fun countReadFacts(): Int
}