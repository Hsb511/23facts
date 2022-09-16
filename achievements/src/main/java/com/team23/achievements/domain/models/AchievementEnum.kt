package com.team23.achievements.domain.models

import com.team23.achievements.R

enum class AchievementEnum(nameResId: Int, imageResId: Int, popupMessageResId: Int) {
    APP_ICON_CLICKED_23_TIMES(R.string.achievements_iconophile, R.drawable.iconophile, R.string.achievements_iconophile_message)
}