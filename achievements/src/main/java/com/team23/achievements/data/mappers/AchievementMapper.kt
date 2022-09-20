package com.team23.achievements.data.mappers

import com.team23.achievements.domain.models.AchievementEnum
import com.team23.achievements.domain.models.AchievementModel
import com.team23.room.data.entities.AchievementEntity

fun List<AchievementEntity>.toListModel() = this.map { it.toModel() }

fun AchievementEntity.toModel() = AchievementModel(
    achievementEnum = AchievementEnum.values().first{ it.name == this.name },
    isFound = this.isFound,
    unlockDate = this.unlockedDate,
)