package com.team23.facts23.presentation

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
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
import androidx.core.animation.doOnEnd
import androidx.core.content.ContextCompat
import com.team23.achievements.presentation.viewmodels.AchievementVM
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.facts23.R
import com.team23.facts23.presentation.themes.Facts23Theme
import com.team23.facts23.presentation.viewmodels.AboutVM
import com.team23.facts23.presentation.views.NavigationView
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
            changeStatusAndNavigationColors = { changeStatusAndNavigationColors() }
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
            Facts23Theme(darkTheme = settingsVM.isDarkMode.value) {
                NavigationView(factDetailVM, homeVM, settingsVM, achievementVM, searchVM, aboutVM)
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
        } catch (e: Exception) {
        }
    }

    private fun changeStatusAndNavigationColors() {
        if (settingsVM.isDarkMode.value) {
            resources.configuration.uiMode = UI_MODE_NIGHT_YES
            window.statusBarColor = ContextCompat.getColor(this, R.color.prussian_blue)
            window.navigationBarColor = ContextCompat.getColor(this, R.color.eerie_black)
        } else {
            resources.configuration.uiMode = UI_MODE_NIGHT_NO
            window.statusBarColor = ContextCompat.getColor(this, R.color.liberty)
            window.navigationBarColor = ContextCompat.getColor(this, R.color.platinum)
        }
    }
}
