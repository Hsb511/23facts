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
    suspend operator fun invoke(): AchievementModel? {
        if (factRepository.countReadFacts() >= 23) {
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