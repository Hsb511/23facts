package com.team23.achievements.presentation.viewobjects

import com.team23.achievements.R


enum class AchievementEnum(val nameResId: Int, val imageResId: Int, val popupMessageResId: Int) {
    ACH1_APP_ICON_CLICKED_23_TIMES(
        R.string.achievements_iconophile,
        R.drawable.iconophile,
        R.string.achievements_iconophile_message
    ),
    ACH2_HOME_ICON_CLICKED_23_SECONDS(
        R.string.achievements_homebody,
        R.drawable.homebody,
        R.string.achievements_homebody_message
    ),
    ACH3_AMOUNT_FACTS_READ_23(
        R.string.achievements_factomania,
        R.drawable.factomania,
        R.string.achievements_factomania_message
    )
}