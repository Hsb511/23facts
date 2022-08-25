package com.team23.fact.data.repositories

import com.team23.fact.domain.models.FactModel
import com.team23.fact.domain.repositories.FactRepository
import com.team23.room.data.daos.FactDao
import javax.inject.Inject

class FactRoomRepository @Inject constructor(
    private val factDao: FactDao
) : FactRepository {
    override suspend fun getFactById(id: Long, language: String) =
        factDao.findById(id, language)?.let {
            FactModel(
                id = it.id_fonc.toString(),
                title = it.title,
                category = it.code,
                image = it.image,
                description = it.content,
                sources = it.links
            )
        }
}