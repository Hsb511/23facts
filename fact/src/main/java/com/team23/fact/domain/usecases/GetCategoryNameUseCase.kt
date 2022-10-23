package com.team23.fact.domain.usecases

import androidx.compose.ui.text.intl.Locale
import com.team23.fact.domain.repositories.CategoryRepository
import javax.inject.Inject

class GetCategoryNameUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend operator fun invoke(code: String?): String = code?.let {
        categoryRepository.getCategoryNameByCode(code).let { category ->
            if (Locale.current.language == "fr") {
                category.nameFr
            } else {
                category.nameEn
            }
        }
    } ?: ""
}
