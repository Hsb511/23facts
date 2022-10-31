package com.team23.facts23.presentation

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.Configuration.*
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.animation.doOnEnd
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.team23.achievements.presentation.viewmodels.AchievementVM
import com.team23.core.domain.Screen
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.facts23.R
import com.team23.facts23.presentation.themes.Facts23Theme
import com.team23.facts23.presentation.viewmodels.AboutVM
import com.team23.facts23.presentation.views.MainView
import com.team23.facts23.presentation.views.NavHost
import com.team23.home.presentation.viewmodels.HomeVM
import com.team23.search.presentation.viewmodels.SearchVM
import com.team23.settings.presentation.viewmodels.SettingsVM
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var factVMAssistedFactory: FactDetailVM.Factory

    @Inject
    lateinit var aboutVMAssistedFactory: AboutVM.Factory

    @Inject
    lateinit var settingsVMAssistedFactory: SettingsVM.Factory

    private val achievementVM: AchievementVM by viewModels()
    private val factDetailVM: FactDetailVM by viewModels {
        FactDetailVM.provideFactory(
            assistedFactory = factVMAssistedFactory,
            factId = null,
            achievementVM = achievementVM,
        )
    }
    private val homeVM: HomeVM by viewModels()
    private val settingsVM: SettingsVM by viewModels {
        SettingsVM.provideFactory(
            assistedFactory = settingsVMAssistedFactory,
            changeStatusAndNavigationColors = { changeStatusAndNavigationColors() },
            resetAchievementData = { achievementVM.onResetAchievements() }
        )
    }
    private val searchVM: SearchVM by viewModels()
    private val aboutVM: AboutVM by viewModels {
        AboutVM.provideFactory(
            assistedFactory = aboutVMAssistedFactory,
            launchEmailIntent = { email -> launchEmailIntent(email) },
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        changeStatusAndNavigationColors()
        setContent {
            val navController = rememberNavController()
            val currentScreen: MutableState<Screen> = remember { mutableStateOf(Screen.Home()) }
            val lastScreen: MutableState<Screen> = remember { mutableStateOf(Screen.Home()) }
            val isMenuExpanded = remember { mutableStateOf(false) }

            Facts23Theme(darkTheme = settingsVM.isDarkMode.value) {
                MainView(
                    factDetailVM = factDetailVM,
                    homeVM = homeVM,
                    achievementVM = achievementVM,
                    navController = navController,
                    currentScreen = currentScreen.value,
                    lastScreen = lastScreen.value,
                    isMenuExpanded = isMenuExpanded
                ) { padding ->
                    NavHost(
                        factDetailVM = factDetailVM,
                        homeVM = homeVM,
                        settingsVM = settingsVM,
                        achievementVM = achievementVM,
                        searchVM = searchVM,
                        aboutVM = aboutVM,
                        navController = navController,
                        currentScreen = currentScreen,
                        lastScreen = lastScreen,
                        isMenuExpanded = isMenuExpanded.value,
                        padding = padding,
                    )
                }
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

    private fun launchEmailIntent(email: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "23facts")

        try {
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        } catch (e: Exception) { }
    }

    private fun changeStatusAndNavigationColors() {
        val isDarkMode = settingsVM.isDarkMode.value ?:
            (resources.configuration.uiMode and UI_MODE_NIGHT_MASK == UI_MODE_NIGHT_YES)
        if (isDarkMode) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.prussian_blue)
            window.navigationBarColor = ContextCompat.getColor(this, R.color.eerie_black)
        } else {
            window.statusBarColor = ContextCompat.getColor(this, R.color.liberty)
            window.navigationBarColor = ContextCompat.getColor(this, R.color.platinum)
        }
    }
}
