package com.team23.achievements.presentation.mappers

import com.team23.achievements.domain.models.AchievementModel
import com.team23.achievements.presentation.viewobjects.AchievementVO

fun List<AchievementModel>.toListVO() = this.map {
    it.toVO()
}

private fun AchievementModel.toVO() = AchievementVO(
    titleResId = this.achievementEnum.nameResId,
    imageResId = this.achievementEnum.imageResId,
    messageResId = this.achievementEnum.popupMessageResId,
    unlockDate = this.unlockDate?.toString(),
)