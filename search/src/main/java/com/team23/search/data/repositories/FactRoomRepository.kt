package com.team23.search.data.repositories

import com.team23.room.data.daos.FactDao
import com.team23.search.data.mappers.toModels
import com.team23.search.domain.models.FactPreview
import com.team23.search.domain.repositories.FactRepository
import javax.inject.Inject

class FactRoomRepository @Inject constructor(
    private val factDao: FactDao
) : FactRepository {
    override suspend fun searchFacts(searchText: String, language: String): List<FactPreview> =
        factDao.loadBySearchTextAndLanguage(searchText, language).toModels()
}