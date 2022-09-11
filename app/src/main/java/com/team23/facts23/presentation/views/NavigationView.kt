package com.team23.facts23.presentation.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.team23.core.domain.ScreenEnum
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.fact.presentation.views.FactDetail
import com.team23.home.presentation.viewmodels.HomeVM
import com.team23.home.presentation.views.HomeCategories
import com.team23.home.presentation.views.HomeFacts
import com.team23.settings.presentation.viewmodels.SettingsVM
import com.team23.settings.presentation.views.SettingsView

@ExperimentalFoundationApi
@Composable
fun NavigationView(factDetailVM: FactDetailVM, homeVM: HomeVM, settingsVM: SettingsVM) {
    val navController = rememberNavController()
    val currentScreen: MutableState<ScreenEnum> = remember { mutableStateOf(ScreenEnum.HOME) }
    val lastScreen: MutableState<ScreenEnum> = remember { mutableStateOf(ScreenEnum.HOME) }
    val isMenuExpanded = remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                pageIndex = currentScreen.value.pageIndex,
                onNavigateHome = {
                    factDetailVM.factDetail.value = null
                    navController.navigate("home")
                },
                onNavigateRandom = {
                    factDetailVM.loadFactDetail("-1")
                    navController.navigate("random")
                },
                onNavigateSearch = { /*TODO*/ },
                onNavigateSettings = { navController.navigate("settings") }
            )
        },
        topBar = {
            TopAppBar(
                screen = currentScreen.value,
                isMenuExpanded = isMenuExpanded,
                onBackPressed = {
                    if (currentScreen.value == ScreenEnum.RANDOM) {
                        factDetailVM.factDetail.value = null
                        navController.navigate(lastScreen.value.route)
                    } else {
                        navController.popBackStack()
                    }
                },
                codeCategory = factDetailVM.factDetail.value?.codeCategory?.ifBlank { null }
                    ?: homeVM.selectedCategory.value?.code,
                nameCategory = factDetailVM.factDetail.value?.category?.ifBlank { null }
                    ?: homeVM.selectedCategory.value?.title,
                factId = factDetailVM.factId
            )
            DropDownMenu(isMenuExpanded = isMenuExpanded, navController = navController)
        },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = ScreenEnum.HOME.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(route = ScreenEnum.HOME.route) {
                currentScreen.value = ScreenEnum.HOME
                HomeCategories(homeVM = homeVM, navController = navController)
            }
            composable(route = ScreenEnum.CATEGORY.route) {
                currentScreen.value = ScreenEnum.CATEGORY
                HomeFacts(homeVM = homeVM, navController = navController)
            }
            composable(route = ScreenEnum.RANDOM.route) {
                if (currentScreen.value != ScreenEnum.RANDOM) {
                    lastScreen.value = currentScreen.value
                }
                currentScreen.value = ScreenEnum.RANDOM
                FactDetail(factDetailVM = factDetailVM)
            }
            composable(route = ScreenEnum.FACT.route) { backStackEntry ->
                currentScreen.value = ScreenEnum.FACT
                factDetailVM.loadFactDetail(backStackEntry.arguments?.getString("factId"))
                FactDetail(factDetailVM = factDetailVM)
            }
            composable(route = ScreenEnum.SETTINGS.route) {
                currentScreen.value = ScreenEnum.SETTINGS
                SettingsView(settingsVM = settingsVM)
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