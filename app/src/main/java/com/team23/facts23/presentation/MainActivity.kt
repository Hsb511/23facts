package com.team23.facts23.presentation

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.core.animation.doOnEnd
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            splashScreen.setOnExitAnimationListener { splashScreenView ->
                // Create your custom animation.
                val slideUp = ObjectAnimator.ofFloat(
                    splashScreenView,
                    View.TRANSLATION_Y,
                    0f,
                    -splashScreenView.height.toFloat()
                )
                slideUp.interpolator = AnticipateInterpolator(1f)
                slideUp.duration = 2000L

                // Call SplashScreenView.remove at the end of your custom animation.
                slideUp.doOnEnd { splashScreenView.remove() }

                // Run your animation.
                slideUp.start()
            }
        }
    }
}
