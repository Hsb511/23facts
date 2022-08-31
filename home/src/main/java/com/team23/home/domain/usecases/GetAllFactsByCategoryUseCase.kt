package com.team23.home.domain.usecases

import androidx.compose.ui.text.intl.Locale
import com.team23.home.domain.models.FactPreviewModel
import com.team23.home.domain.repositories.FactRepository
import javax.inject.Inject

class GetAllFactsByCategoryUseCase @Inject constructor(
    private val factRepository: FactRepository
){
    suspend fun execute(categoryCode: String): List<FactPreviewModel> =
        factRepository.getFactsByCategory(categoryCode, Locale.current.language)

}