package com.team23.fact.domain.usecases

import androidx.compose.ui.text.intl.Locale
import com.team23.fact.domain.models.FactModel
import com.team23.fact.domain.repositories.FactRepository
import javax.inject.Inject

class GetAndReadFactUseCase @Inject constructor(
    private val factRepository: FactRepository
) {
    suspend fun execute(id: String?): FactModel? =
        id?.toLongOrNull()?.let {
            val localLanguage = Locale.current.language
            if (it == -1L) {
                factRepository.getRandomFact(localLanguage)
            } else {
                factRepository.getFactById(it, localLanguage)
            }?.also { fact ->
                factRepository.setNewToFalseById(fact.id.toLong())
            }
    }
}