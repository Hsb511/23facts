package com.team23.achievements.models

import java.util.Date

data class AchievementModel(
    val name: String,
    val isFound: Boolean,
    val unlockDate: Date?,
)
