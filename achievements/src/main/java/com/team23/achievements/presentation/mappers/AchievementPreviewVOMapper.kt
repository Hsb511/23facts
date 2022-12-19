package com.team23.achievements.presentation.mappers

import com.team23.achievements.models.AchievementModel
import com.team23.achievements.presentation.viewobjects.AchievementEnum
import com.team23.achievements.presentation.viewobjects.AchievementPreviewVO


fun AchievementModel.toPreviewVO(): AchievementPreviewVO {
    val enum = AchievementEnum.values().first{ it.name == this.name }
    return AchievementPreviewVO(
        imageResId = enum.imageResId,
        messageResId = enum.popupMessageResId
    )
}