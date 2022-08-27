package com.team23.fact.domain.usecases

import androidx.compose.ui.text.intl.Locale
import com.team23.fact.domain.models.FactModel
import com.team23.fact.domain.repositories.FactRepository
import javax.inject.Inject

class GetFactUseCase @Inject constructor(
    private val factRepository: FactRepository
) {
    suspend fun execute(id: String?): FactModel? =
        id?.toLongOrNull()?.let {
            factRepository.getFactById(it, Locale.current.language)
    }
}