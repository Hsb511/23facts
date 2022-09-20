package com.team23.achievements.domain.models

import com.team23.achievements.R

enum class AchievementEnum(val nameResId: Int, val imageResId: Int, val popupMessageResId: Int) {
    APP_ICON_CLICKED_23_TIMES(R.string.achievements_iconophile, R.drawable.iconophile, R.string.achievements_iconophile_message),
    HOME_ICON_CLICKED_23_SECONDS(R.string.achievements_homebody, R.drawable.homebody, R.string.achievements_homebody_message)
}