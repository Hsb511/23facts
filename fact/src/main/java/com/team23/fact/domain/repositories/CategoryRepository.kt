package com.team23.fact.domain.repositories

import com.team23.fact.domain.models.CategoryModel

interface CategoryRepository {
    suspend fun getCategoryNameByCode(code: String): CategoryModel
}