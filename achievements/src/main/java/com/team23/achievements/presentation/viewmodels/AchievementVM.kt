package com.team23.achievements.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team23.achievements.domain.models.AchievementEnum
import com.team23.achievements.domain.usecases.IsSpecificAchievementFoundUseCase
import com.team23.achievements.domain.usecases.Unlock1IconophileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AchievementVM @Inject constructor(
    private val unlock1IconophileUseCase: Unlock1IconophileUseCase,
    private val isSpecificAchievementFoundUseCase: IsSpecificAchievementFoundUseCase
) : ViewModel() {
    private var timesAmountAppIconClicked = 0 // TODO STORE IN DATABASE
    var isIconophileDisplayed: Boolean = false
    init {
        viewModelScope.launch(Dispatchers.IO) {
            isSpecificAchievementFoundUseCase(AchievementEnum.APP_ICON_CLICKED_23_TIMES.name).also {
                isIconophileDisplayed = it
            }
        }
    }


    fun onAppIconClicked() {
        if (!isIconophileDisplayed) {
            timesAmountAppIconClicked ++
            viewModelScope.launch(Dispatchers.IO) {
                val achievement = unlock1IconophileUseCase.invoke(timesAmountAppIconClicked)
                achievement?.let {
                    // TODO SHOW POPUP
                    println("23")
                    isIconophileDisplayed = true
                }
            }
        }
    }
}