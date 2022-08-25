package com.team23.fact.domain.usecases

import com.team23.fact.domain.repositories.CategoryRepository
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend fun execute(code: String?) = code?.let {
        categoryRepository.getCategoryNameByCode(code).let { category ->
            // TODO GET SYSTEM LANGUAGE
            val language = "fr"
            if (language == "fr") {
                category.nameFr
            } else {
                category.nameEn
            }
        }
    } ?: ""
}
