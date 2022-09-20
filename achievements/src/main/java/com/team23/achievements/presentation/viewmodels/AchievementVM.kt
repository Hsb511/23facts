package com.team23.achievements.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team23.achievements.domain.models.AchievementEnum
import com.team23.achievements.domain.usecases.GetAllAchievementsUseCase
import com.team23.achievements.domain.usecases.IsSpecificAchievementFoundUseCase
import com.team23.achievements.domain.usecases.Unlock1IconophileUseCase
import com.team23.achievements.presentation.mappers.toListVO
import com.team23.achievements.presentation.mappers.toPreviewVO
import com.team23.achievements.presentation.viewobjects.AchievementPreviewVO
import com.team23.achievements.presentation.viewobjects.AchievementVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AchievementVM @Inject constructor(
    private val getAllAchievementsUseCase: GetAllAchievementsUseCase,
    private val unlock1IconophileUseCase: Unlock1IconophileUseCase,
    private val isSpecificAchievementFoundUseCase: IsSpecificAchievementFoundUseCase
) : ViewModel() {
    val achievements = mutableStateListOf<AchievementVO>()
    private var timesAmountAppIconClicked = 0 // TODO STORE IN DATABASE
    var isIconophileDisplayed: Boolean = false
    val achievementPreviewToDisplay: MutableState<AchievementPreviewVO?> = mutableStateOf(null)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllAchievementsUseCase.invoke().also {
                withContext(Dispatchers.Main) {
                    achievements.addAll(it.toListVO())
                }
            }
            isSpecificAchievementFoundUseCase(AchievementEnum.APP_ICON_CLICKED_23_TIMES.name).also {
                isIconophileDisplayed = it
            }
        }
    }

    fun onAppIconClicked() {
        if (!isIconophileDisplayed) {
            timesAmountAppIconClicked++
            viewModelScope.launch(Dispatchers.IO) {
                achievementPreviewToDisplay.value =
                    unlock1IconophileUseCase.invoke(timesAmountAppIconClicked)?.let {
                        isIconophileDisplayed = true
                        it.toPreviewVO()
                    }
            }
        }
    }
}