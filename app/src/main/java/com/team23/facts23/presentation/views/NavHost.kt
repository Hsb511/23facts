package com.team23.facts23.presentation.views


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.team23.achievements.presentation.viewmodels.AchievementVM
import com.team23.achievements.presentation.views.AchievementView
import com.team23.core.domain.Screen
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.fact.presentation.views.FactDetail
import com.team23.facts23.presentation.viewmodels.AboutVM
import com.team23.home.presentation.viewmodels.HomeVM
import com.team23.home.presentation.views.HomeCategories
import com.team23.home.presentation.views.HomeFacts
import com.team23.search.presentation.viewmodels.SearchVM
import com.team23.search.presentation.views.SearchView
import com.team23.settings.presentation.viewmodels.SettingsVM
import com.team23.settings.presentation.views.SettingsView

@ExperimentalFoundationApi
@Composable
fun NavHost(
    factDetailVM: FactDetailVM,
    homeVM: HomeVM,
    settingsVM: SettingsVM,
    achievementVM: AchievementVM,
    searchVM: SearchVM,
    aboutVM: AboutVM,
    padding: PaddingValues,
    navController: NavHostController,
    currentScreen: MutableState<Screen>,
    lastScreen: MutableState<Screen>,
    isMenuExpanded: Boolean,
) {


    NavHost(
        navController = navController,
        startDestination = Screen.Home().route,
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
    ) {
        composable(route = Screen.Home().route) {
            currentScreen.value = Screen.Home()
            HomeCategories(homeVM = homeVM, navController = navController)
        }
        composable(route = Screen.Category().route) {
            currentScreen.value = Screen.Category()
            HomeFacts(homeVM = homeVM, navController = navController)
        }
        composable(route = Screen.Random().route) {
            if (currentScreen.value != Screen.Random()) {
                lastScreen.value = currentScreen.value
            }
            currentScreen.value = Screen.Random()
            homeVM.selectedCategory.value = null
            FactDetail(factDetailVM = factDetailVM)
        }
        composable(route = Screen.Fact().route) { backStackEntry ->
            currentScreen.value = Screen.Fact()
            factDetailVM.loadFactDetail(backStackEntry.arguments?.getString("factId"))
            FactDetail(factDetailVM = factDetailVM)
        }
        composable(route = Screen.Settings().route) {
            currentScreen.value = Screen.Settings()
            SettingsView(settingsVM = settingsVM)
        }
        composable(route = Screen.About().route) {
            currentScreen.value = Screen.About()
            AboutView(aboutVM = aboutVM)
        }
        composable(route = Screen.Achievement().route) {
            currentScreen.value = Screen.Achievement()
            AchievementView(achievementVM = achievementVM)
        }
        composable(route = Screen.Search().route) {
            currentScreen.value = Screen.Search()
            SearchView(searchVM = searchVM, navController = navController)
        }
    }
    if (isMenuExpanded) {
        Surface(
            color = Color.Black.copy(alpha = 0.6f),
            modifier = Modifier.fillMaxSize()
        ) {}
    }
}