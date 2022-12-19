package com.team23.achievements.presentation.viewobjects


fun AchievementEnum.isLocked(achievements: List<AchievementVO>) = achievements.any {
    it.id == this.ordinal && it.unlockDate == null
}