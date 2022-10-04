package com.team23.achievements.presentation.viewobjects

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class AchievementPreviewVO(
    @DrawableRes val imageResId: Int,
    @StringRes val messageResId: Int
)
