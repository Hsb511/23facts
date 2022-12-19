package com.team23.achievements.usecases

import com.team23.achievements.repositories.AchievementRepository
import javax.inject.Inject

class GetAllAchievementsUseCase @Inject constructor(
    private val achievementRepository: AchievementRepository
) {
    suspend fun invoke() = achievementRepository.loadAll()
}