package com.team23.achievements.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team23.achievements.domain.models.AchievementEnum.*
import com.team23.achievements.domain.usecases.GetAllAchievementsUseCase
import com.team23.achievements.domain.usecases.Unlock1IconophileUseCase
import com.team23.achievements.domain.usecases.Unlock3FactomaniaUseCase
import com.team23.achievements.presentation.mappers.toAchievementStringDate
import com.team23.achievements.presentation.mappers.toListVO
import com.team23.achievements.presentation.mappers.toPreviewVO
import com.team23.achievements.presentation.viewobjects.AchievementPreviewVO
import com.team23.achievements.presentation.viewobjects.AchievementVO
import com.team23.achievements.presentation.viewobjects.isLocked
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AchievementVM @Inject constructor(
    private val getAllAchievementsUseCase: GetAllAchievementsUseCase,
    private val unlock1IconophileUseCase: Unlock1IconophileUseCase,
    private val unlock3FactomaniaUseCase: Unlock3FactomaniaUseCase,
) : ViewModel() {
    val achievements by lazy {
        mutableStateListOf<AchievementVO>()
    }
    private var timesAmountAppIconClicked = 0 // TODO STORE IN DATABASE
    var achievementPreviewToDisplay: MutableState<AchievementPreviewVO?> = mutableStateOf(null)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllAchievementsUseCase.invoke().also {
                withContext(Dispatchers.Main) {
                    achievements.addAll(it.toListVO())
                }
            }
        }
    }

    fun onAppIconClicked() {
        if (ACH1_APP_ICON_CLICKED_23_TIMES.isLocked(achievements)) {
            timesAmountAppIconClicked++
            viewModelScope.launch(Dispatchers.IO) {
                achievementPreviewToDisplay.value =
                    unlock1IconophileUseCase.invoke(timesAmountAppIconClicked)?.let {
                        achievements[ACH1_APP_ICON_CLICKED_23_TIMES.ordinal].apply {
                            this.unlockDate = it.unlockDate?.toAchievementStringDate()
                        }
                        it.toPreviewVO()
                    }
            }
        }
    }

    fun onFactLoaded() {
        if (ACH3_AMOUNT_FACTS_READ_23.isLocked(achievements)) {
            viewModelScope.launch(Dispatchers.IO) {
                achievementPreviewToDisplay.value = unlock3FactomaniaUseCase()?.let {
                    achievements[ACH3_AMOUNT_FACTS_READ_23.ordinal].apply {
                        this.unlockDate = it.unlockDate?.toAchievementStringDate()
                    }
                    it.toPreviewVO()
                }
            }
        }
    }
}