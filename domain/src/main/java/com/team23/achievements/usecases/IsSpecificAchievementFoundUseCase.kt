package com.team23.achievements.usecases

import com.team23.achievements.repositories.AchievementRepository
import javax.inject.Inject

class IsSpecificAchievementFoundUseCase @Inject constructor(
    private val achievementRepository: AchievementRepository
){
    suspend operator fun invoke(achievementName: String) = achievementRepository.findIsFoundByName(achievementName)
}