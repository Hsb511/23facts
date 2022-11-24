package com.team23.fact.data.repositories

import com.team23.fact.data.mappers.toModel
import com.team23.fact.domain.models.FactModel
import com.team23.fact.domain.repositories.FactRepository
import com.team23.room.data.daos.FactDao
import javax.inject.Inject

class FactRoomRepository @Inject constructor(
    private val factDao: FactDao
) : FactRepository {
    override suspend fun getFactById(id: Long, language: String) =
        factDao.findByIdAndLanguage(id, language)?.toModel()

    override suspend fun getRandomFact(language: String) =
        factDao.findRandomByLanguage(language)?.toModel()

    override suspend fun getRandomAmongUnreadFact(language: String) =
        factDao.findRandomUnreadByLanguage(language)?.toModel()

    override suspend fun setNewToFalseById(id: Long) {
        factDao.updateNewById(id)
    }
}