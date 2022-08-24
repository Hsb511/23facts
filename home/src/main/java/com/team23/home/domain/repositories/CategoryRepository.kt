package com.team23.home.domain.repositories

import com.team23.home.domain.models.CategoryModel

interface CategoryRepository {
    suspend fun loadCategories(language: String): List<CategoryModel>
}