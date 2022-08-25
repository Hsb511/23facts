package com.team23.fact.data.repositories

import com.team23.fact.domain.models.CategoryModel
import com.team23.fact.domain.repositories.CategoryRepository
import com.team23.room.data.daos.CategoryDao
import javax.inject.Inject

class CategoryRoomRepository @Inject constructor(
    private val categoryDao: CategoryDao
): CategoryRepository {
    override suspend fun getCategoryNameByCode(code: String) = categoryDao.findByCode(code)?.let {
        CategoryModel(
            nameEn = it.name_en,
            nameFr = it.name_fr
        )
    }?: CategoryModel("", "")
}