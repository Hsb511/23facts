package com.team23.home.data.repositories

import com.team23.home.domain.models.FactPreviewModel
import com.team23.home.domain.repositories.FactRepository
import com.team23.room.data.daos.FactDao
import javax.inject.Inject

class FactRoomRepository @Inject constructor(
    private val factDao: FactDao
): FactRepository {
    override suspend fun getFactsByCategory(codeCategory: String, language: String): List<FactPreviewModel> =
        factDao.findByCategoryAndLanguage(codeCategory, language).map {
            FactPreviewModel(
                id = it.id_fonc,
                picture = it.image,
                title = it.title,
                new = it.isNew
            )
        }

}