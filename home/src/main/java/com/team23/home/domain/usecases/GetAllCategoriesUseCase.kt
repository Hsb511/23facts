package com.team23.home.domain.usecases

import androidx.compose.ui.text.intl.Locale
import com.team23.home.domain.repositories.CategoryRepository
import com.team23.home.presentation.viewobjects.CategoryVO
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    suspend fun execute(): List<CategoryVO> = categoryRepository.loadCategories().map {
        CategoryVO(
            code = it.code,
            title = if (Locale.current.language == "fr") {
                it.titleFr
            } else {
                it.titleEn
            },
            shortTitle = if (Locale.current.language == "fr") {
                it.shortTitleFr
            } else {
                it.shortTitleEn
            },
        )

    }
}