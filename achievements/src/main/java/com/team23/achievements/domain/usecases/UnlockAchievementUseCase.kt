package com.team23.achievements.domain.usecases

import com.team23.achievements.domain.models.AchievementEnum
import com.team23.achievements.domain.repositories.AchievementRepository
import java.util.*
import javax.inject.Inject

class UnlockAchievementUseCase @Inject constructor(
    private val achievementRepository: AchievementRepository
) {
    suspend operator fun invoke(achievement: AchievementEnum) {
        achievementRepository.unlockAchievement(achievement.name, Date())
    }
}