package com.team23.fact.domain.usecases

import androidx.compose.ui.text.intl.Locale
import com.team23.fact.domain.repositories.CategoryRepository
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend fun execute(code: String?) = code?.let {
        categoryRepository.getCategoryNameByCode(code).let { category ->
            if (Locale.current.language == "fr") {
                category.nameFr
            } else {
                category.nameEn
            }
        }
    } ?: ""
}
