package com.team23.achievements.presentation.mappers

import com.team23.achievements.domain.models.AchievementModel
import com.team23.achievements.presentation.viewobjects.AchievementVO
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

private val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE)

fun List<AchievementModel>.toListVO() = this.map {
    it.toVO()
}

private fun AchievementModel.toVO() = AchievementVO(
    id = this.achievementEnum.ordinal,
    titleResId = this.achievementEnum.nameResId,
    imageResId = this.achievementEnum.imageResId,
    messageResId = this.achievementEnum.popupMessageResId,
    unlockDate = this.unlockDate?.toAchievementStringDate(),
)

fun Date.toAchievementStringDate(): String = formatter.format(this)