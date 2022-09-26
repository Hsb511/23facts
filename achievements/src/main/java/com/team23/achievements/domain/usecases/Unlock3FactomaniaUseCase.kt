package com.team23.achievements.domain.usecases

import com.team23.achievements.domain.models.AchievementEnum
import com.team23.achievements.domain.repositories.FactRepository
import com.team23.achievements.presentation.viewobjects.AchievementPreviewVO
import javax.inject.Inject


class Unlock3FactomaniaUseCase @Inject constructor(
    private val unlockAchievementUseCase: UnlockAchievementUseCase,
    private val factRepository: FactRepository,
) {
    suspend operator fun invoke(): AchievementPreviewVO? {
        if (factRepository.countReadFacts() >= 23) {
            unlockAchievementUseCase(AchievementEnum.AMOUNT_FACTS_READ_23)
            return AchievementPreviewVO(
                imageResId = AchievementEnum.AMOUNT_FACTS_READ_23.imageResId,
                messageResId = AchievementEnum.AMOUNT_FACTS_READ_23.popupMessageResId
            )
        }
        return null
    }
}