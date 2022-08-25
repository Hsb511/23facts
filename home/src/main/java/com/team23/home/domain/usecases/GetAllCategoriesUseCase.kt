package com.team23.home.domain.usecases

import com.team23.home.domain.repositories.CategoryRepository
import com.team23.home.presentation.viewobjects.CategoryVO
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend fun execute() = categoryRepository.loadCategories().map {
        // TODO GET SYSTEM LANGUAGE
        val language = "fr"
        CategoryVO(
            code = it.code,
            title = if (language == "fr") {
                it.titleFr
            } else {
                it.titleEn
            }
        )

    }
}