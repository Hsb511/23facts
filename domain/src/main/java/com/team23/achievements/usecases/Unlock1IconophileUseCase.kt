package com.team23.achievements.usecases

import com.team23.achievements.models.AchievementModel
import java.util.Date
import javax.inject.Inject

class Unlock1IconophileUseCase @Inject constructor(
    private val unlockAchievementUseCase: UnlockAchievementUseCase
) {
    companion object {
        private const val CLICK_AMOUNT_TO_UNLOCK_SECRET = 23
    }

    suspend fun invoke(clickAmount: Int, achievementName: String): AchievementModel? {
        if (clickAmount >= CLICK_AMOUNT_TO_UNLOCK_SECRET) {
            unlockAchievementUseCase(achievementName)
            return AchievementModel(
                name = achievementName,
                isFound = true,
                unlockDate = Date()
            )
        }
        return null
    }
}