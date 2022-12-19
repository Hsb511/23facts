package com.team23.achievements.presentation.mappers

import com.team23.achievements.models.AchievementModel
import com.team23.achievements.presentation.viewobjects.AchievementEnum
import com.team23.achievements.presentation.viewobjects.AchievementVO
import java.text.SimpleDateFormat
import java.util.*

private val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.FRANCE)

fun List<AchievementModel>.toListVO() = this.map {
    it.toVO()
}

private fun AchievementModel.toVO(): AchievementVO =
    AchievementEnum.values().first{ it.name == this.name }.let {
        AchievementVO(
            id = it.ordinal,
            titleResId = it.nameResId,
            imageResId = it.imageResId,
            messageResId = it.popupMessageResId,
            unlockDate = this.unlockDate?.toAchievementStringDate(),
        )
    }


fun Date.toAchievementStringDate(): String = formatter.format(this)