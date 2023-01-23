package com.team23.achievements.usecases

import com.team23.achievements.models.AchievementModel
import com.team23.achievements.repositories.FactAchievementRepository
import java.util.*
import javax.inject.Inject

class Unlock4VersatileUseCase @Inject constructor(
    private val unlockAchievementUseCase: UnlockAchievementUseCase,
) {
    companion object {
        private const val CLICK_AMOUNT_TO_UNLOCK_SECRET = 23
    }

    suspend fun invoke(settingsChangedAmount: Int, achievementName: String): AchievementModel? {
        if (settingsChangedAmount >= CLICK_AMOUNT_TO_UNLOCK_SECRET) {
            unlockAchievementUseCase.invoke(achievementName)
            return AchievementModel(
                name = achievementName,
                isFound = true,
                unlockDate = Date()
            )
        }
        return null
    }
}