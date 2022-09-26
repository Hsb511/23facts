package com.team23.facts23.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import com.team23.achievements.presentation.viewmodels.AchievementVM
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.facts23.presentation.themes.Facts23Theme
import com.team23.facts23.presentation.views.NavigationView
import com.team23.home.presentation.viewmodels.HomeVM
import com.team23.settings.presentation.viewmodels.SettingsVM
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var viewModelAssistedFactory: FactDetailVM.Factory

    private val achievementVM: AchievementVM by viewModels()
    private val factDetailVM: FactDetailVM by viewModels {
        FactDetailVM.provideFactory(
            assistedFactory = viewModelAssistedFactory,
            factId = null,
            achievementVM = achievementVM,
        )
    }
    private val homeVM: HomeVM by viewModels()
    private val settingsVM: SettingsVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Facts23Theme(darkTheme = settingsVM.isForcedDarkMode.value ?: isSystemInDarkTheme()) {
                NavigationView(factDetailVM, homeVM, settingsVM, achievementVM)
            }
        }
    }
}
