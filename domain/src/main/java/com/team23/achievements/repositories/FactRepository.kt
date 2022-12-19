package com.team23.achievements.repositories

interface FactRepository {
    suspend fun countReadFacts(): Int
}