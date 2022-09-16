package com.team23.achievements.domain.usecases

import com.team23.achievements.domain.repositories.AchievementRepository
import javax.inject.Inject

class IsSpecificAchievementFoundUseCase @Inject constructor(
    private val achievementRepository: AchievementRepository
){
    suspend operator fun invoke(achievementName: String) = achievementRepository.findIsFoundByName(achievementName)
}