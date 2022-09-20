package com.team23.achievements.presentation.mappers

import com.team23.achievements.domain.models.AchievementModel
import com.team23.achievements.presentation.viewobjects.AchievementPreviewVO

fun AchievementModel.toPreviewVO() = AchievementPreviewVO(
    imageResId = this.achievementEnum.imageResId,
    messageResId = this.achievementEnum.popupMessageResId
)