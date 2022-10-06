package com.team23.settings.domain.usecases

import com.team23.settings.domain.repositories.AchievementRepository
import com.team23.settings.domain.repositories.FactRepository
import javax.inject.Inject

class ResetDatabaseUseCase @Inject constructor(
    private val factRepository: FactRepository,
    private val achievementRepository: AchievementRepository,
) {
    suspend operator fun invoke() {
        factRepository.resetFacts()
        achievementRepository.resetAchievements()
    }
}