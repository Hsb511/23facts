package com.team23.achievements.usecases

import com.team23.achievements.repositories.AchievementRepository
import java.util.*
import javax.inject.Inject

class UnlockAchievementUseCase @Inject constructor(
    private val achievementRepository: AchievementRepository
) {
    suspend operator fun invoke(name: String) {
        achievementRepository.unlockAchievement(name, Date())
    }
}