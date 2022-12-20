package com.team23.achievements.usecases

import com.team23.achievements.models.AchievementModel
import com.team23.achievements.repositories.FactRepository
import java.util.Date
import javax.inject.Inject


class Unlock3FactomaniaUseCase @Inject constructor(
    private val unlockAchievementUseCase: UnlockAchievementUseCase,
    private val factRepository: FactRepository,
) {
    companion object {
        private const val FACTS_AMOUNT_TO_UNLOCK_SECRET = 23
        private const val LANGUAGE_AMOUNT = 2
    }

    suspend operator fun invoke(achievementName: String): AchievementModel? = runCatching {
        if (factRepository.countReadFacts() >= FACTS_AMOUNT_TO_UNLOCK_SECRET * LANGUAGE_AMOUNT) {
            unlockAchievementUseCase(achievementName)
            return AchievementModel(
                name = achievementName,
                isFound = true,
                unlockDate = Date(),
            )
        }
        return null
    }.getOrNull()
}