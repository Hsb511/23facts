package com.team23.achievements.data.repositories

import com.team23.achievements.domain.repositories.FactRepository
import com.team23.room.data.daos.FactDao
import javax.inject.Inject

class FactRepositoryImpl @Inject constructor(
    private val factDao: FactDao
): FactRepository {
    override suspend fun countReadFacts() = factDao.countReadFacts()
}