package com.team23.facts23.presentation.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun NavigationView(
    factDetailVM: FactDetailVM,
    homeVM: HomeVM,
    settingsVM: SettingsVM,
    achievementVM: AchievementVM,
    searchVM: SearchVM,
    aboutVM: AboutVM
) {
    val navController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val currentScreen: MutableState<Screen> = remember { mutableStateOf(Screen.Home()) }
    val lastScreen: MutableState<Screen> = remember { mutableStateOf(Screen.Home()) }
    val isMenuExpanded = remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost = {
            achievementVM.achievementPreviewToDisplay.value?.let {
                SnackbarHost(
                    achievementPreview = it,
                    hostState = snackbarHostState
                )
                scope.launch {
                    snackbarHostState.showSnackbar(it.messageResId.toString())
                }
            }
        },
        bottomBar = {
            BottomAppBar(
                pageIndex = currentScreen.value.pageIndex,
                onNavigateHome = {
                    factDetailVM.factDetail.value = null
                    navController.navigate(Screen.Home().route)
                },
                onNavigateRandom = {
                    factDetailVM.loadFactDetail("-1")
                    navController.navigate(Screen.Random().route)
                },
                onNavigateSearch = {
                    navController.navigate(Screen.Search().route)
                }
            )
        },
        topBar = {
            TopAppBar(
                screen = currentScreen.value,
                isMenuExpanded = isMenuExpanded,
                onBackPressed = {
                    when (currentScreen.value) {
                        is Screen.Random -> {
                            factDetailVM.factDetail.value = null
                            navController.navigate(lastScreen.value.route)
                        }
                        is Screen.Category -> {
                            factDetailVM.factDetail.value = null
                            navController.popBackStack()
                        }
                        else -> {
                            navController.popBackStack()
                        }
                    }
                },
                codeCategory = factDetailVM.factDetail.value?.codeCategory?.ifBlank { null }
                    ?: homeVM.selectedCategory.value?.code,
                nameCategory = factDetailVM.factDetail.value?.category?.ifBlank { null }
                    ?: homeVM.selectedCategory.value?.title,
                factId = factDetailVM.factId,
                onAppIconClicked = { achievementVM.onAppIconClicked() }
            )
            DropDownMenu(isMenuExpanded = isMenuExpanded, navController = navController)
        },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home().route,
            modifier = Modifier.padding(padding)
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
        if (isMenuExpanded.value) {
            Surface(
                color = Color.Black.copy(alpha = 0.6f),
                modifier = Modifier.fillMaxSize()
            ) {}
        }
    }
}