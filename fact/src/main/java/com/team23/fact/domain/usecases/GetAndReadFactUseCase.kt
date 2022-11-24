package com.team23.fact.domain.usecases

import androidx.compose.ui.text.intl.Locale
import com.team23.fact.domain.models.FactModel
import com.team23.fact.domain.repositories.FactRepository
import com.team23.fact.domain.repositories.SettingsRepository
import javax.inject.Inject

class GetAndReadFactUseCase @Inject constructor(
    private val factRepository: FactRepository,
    private val settingsRepository: SettingsRepository
) {
    suspend fun execute(id: String?): FactModel? =
        id?.toLongOrNull()?.let {
            val localLanguage = Locale.current.language
            if (it == -1L) {
                if (settingsRepository.getRandomnessSetting() == "RANDOM_AMONG_UNREAD") {
                    factRepository.getRandomAmongUnreadFact(localLanguage)
                } else {
                    factRepository.getRandomFact(localLanguage)
                }
            } else {
                factRepository.getFactById(it, localLanguage)
            }?.also { fact ->
                factRepository.setNewToFalseById(fact.id.toLong())
            }
    }
}