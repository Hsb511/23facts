package com.team23.achievements.domain.models

import com.team23.achievements.R

enum class AchievementEnum(val nameResId: Int, val imageResId: Int, val popupMessageResId: Int) {
    APP_ICON_CLICKED_23_TIMES(R.string.achievements_iconophile, R.drawable.iconophile, R.string.achievements_iconophile_message)
}