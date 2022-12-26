package com.team23.search.data.repositories

import com.team23.search.repositories.FactSearchRepository
import com.team23.search.models.FactPreview
import com.team23.room.data.daos.FactDao
import com.team23.search.data.mappers.toModels
import javax.inject.Inject

class FactSearchRepositoryImpl @Inject constructor(
    private val factDao: FactDao
) : FactSearchRepository {
    override suspend fun searchFacts(searchText: String, language: String): List<FactPreview> =
        factDao.loadBySearchTextAndLanguage(searchText, language).toModels()
}