package com.team23.achievements.presentation.viewobjects

data class AchievementVO(
    val id: Int,
    val titleResId: Int,
    val imageResId: Int,
    val messageResId: Int,
    var unlockDate: String?
)
