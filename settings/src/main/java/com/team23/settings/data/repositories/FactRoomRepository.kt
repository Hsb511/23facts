package com.team23.settings.data.repositories

import com.team23.room.data.daos.FactDao
import com.team23.settings.domain.repositories.FactRepository
import javax.inject.Inject

class FactRoomRepository @Inject constructor(
    private val factDao: FactDao
): FactRepository {
    override suspend fun resetFacts() {
        factDao.resetData()
    }
}