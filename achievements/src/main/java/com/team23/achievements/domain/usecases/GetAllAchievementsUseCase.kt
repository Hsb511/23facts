package com.team23.achievements.domain.usecases

import com.team23.achievements.domain.repositories.AchievementRepository
import javax.inject.Inject

class GetAllAchievementsUseCase @Inject constructor(
    private val achievementRepository: AchievementRepository
) {
    suspend fun invoke() = achievementRepository.loadAll()
}