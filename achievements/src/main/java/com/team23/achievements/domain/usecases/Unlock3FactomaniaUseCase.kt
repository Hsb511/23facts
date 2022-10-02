package com.team23.achievements.domain.usecases

import com.team23.achievements.domain.models.AchievementEnum
import com.team23.achievements.domain.models.AchievementModel
import com.team23.achievements.domain.repositories.FactRepository
import java.util.*
import javax.inject.Inject


class Unlock3FactomaniaUseCase @Inject constructor(
    private val unlockAchievementUseCase: UnlockAchievementUseCase,
    private val factRepository: FactRepository,
) {
    companion object {
        private const val FACTS_AMOUNT_TO_UNLOCK_SECRET = 23
        private const val LANGUAGE_AMOUNT = 2
    }

    suspend operator fun invoke(): AchievementModel? {
        if (factRepository.countReadFacts() >= FACTS_AMOUNT_TO_UNLOCK_SECRET * LANGUAGE_AMOUNT) {
            unlockAchievementUseCase(AchievementEnum.ACH3_AMOUNT_FACTS_READ_23)
            return AchievementModel(
                achievementEnum = AchievementEnum.ACH3_AMOUNT_FACTS_READ_23,
                isFound = true,
                unlockDate = Date(),
            )
        }
        return null
    }
}