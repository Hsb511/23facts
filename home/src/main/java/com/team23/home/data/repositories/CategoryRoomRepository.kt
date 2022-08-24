package com.team23.home.data.repositories

import com.team23.home.data.mappers.toModel
import com.team23.home.domain.models.CategoryModel
import com.team23.home.domain.repositories.CategoryRepository
import com.team23.room.data.daos.CategoryDao
import javax.inject.Inject

class CategoryRoomRepository @Inject constructor(
    private val categoryDao: CategoryDao
): CategoryRepository {
    override suspend fun loadCategories(): List<CategoryModel> =
        categoryDao.loadAll().map { it.toModel() }
}