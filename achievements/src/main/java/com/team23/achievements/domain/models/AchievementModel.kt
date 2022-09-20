package com.team23.achievements.domain.models

import java.util.Date

data class AchievementModel(
    val achievementEnum: AchievementEnum,
    val isFound: Boolean,
    val unlockDate: Date?,
)
