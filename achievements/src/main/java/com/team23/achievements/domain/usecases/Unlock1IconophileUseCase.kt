package com.team23.achievements.domain.usecases

import com.team23.achievements.domain.models.AchievementEnum
import javax.inject.Inject

class Unlock1IconophileUseCase @Inject constructor(
    private val unlockAchievementUseCase: UnlockAchievementUseCase
) {
    suspend fun invoke() {
        unlockAchievementUseCase(AchievementEnum.APP_ICON_CLICKED_23_TIMES)
    }
}