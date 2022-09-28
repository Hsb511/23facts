package com.team23.achievements.presentation.viewobjects

import com.team23.achievements.domain.models.AchievementEnum

fun AchievementEnum.isLocked(achievements: List<AchievementVO>) = achievements.any {
    it.id == this.ordinal && it.unlockDate == null
}