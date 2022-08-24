package com.team23.home.domain.usecases

import com.team23.home.domain.repositories.CategoryRepository
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend fun execute(language: String) = categoryRepository.loadCategories().map {
        if (language == "fr") {
            it.titleFr
        } else {
            it.titleEn
        }
    }
}