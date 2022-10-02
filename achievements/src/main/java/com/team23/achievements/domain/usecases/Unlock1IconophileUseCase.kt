package com.team23.achievements.domain.usecases

import com.team23.achievements.domain.models.AchievementEnum
import com.team23.achievements.domain.models.AchievementModel
import java.util.*
import javax.inject.Inject

class Unlock1IconophileUseCase @Inject constructor(
    private val unlockAchievementUseCase: UnlockAchievementUseCase
) {
    companion object {
        private const val CLICK_AMOUNT_TO_UNLOCK_SECRET = 23
    }

    suspend fun invoke(clickAmount: Int): AchievementModel? {
        if (clickAmount >= CLICK_AMOUNT_TO_UNLOCK_SECRET) {
            unlockAchievementUseCase(AchievementEnum.ACH1_APP_ICON_CLICKED_23_TIMES)
            return AchievementModel(
                achievementEnum = AchievementEnum.ACH1_APP_ICON_CLICKED_23_TIMES,
                isFound = true,
                unlockDate = Date()
            )
        }
        return null
    }
}