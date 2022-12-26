package com.team23.achievements.data.repositories

import com.team23.achievements.repositories.FactAchievementRepository
import com.team23.room.data.daos.FactDao
import javax.inject.Inject

internal class FactAchievementRepositoryImpl @Inject constructor(
    private val factDao: FactDao
): FactAchievementRepository {
    override suspend fun countReadFacts() = factDao.countReadFacts()
}