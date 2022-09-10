package com.team23.facts23.presentation.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

    Scaffold(
        bottomBar = {
            BottomAppBar(
                onNavigateHome = { navController.navigate("home") },
                onNavigateRandom = {
                    factDetailVM.loadFactDetail("-1")
                    navController.navigate("random")
                },
                onNavigateSearch = { /*TODO*/ },
                onNavigateSettings = { navController.navigate("settings") }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable(route = "random") {
                FactDetail(factDetailVM = factDetailVM)
            }
            composable(route = "fact/{factId}") { backStackEntry ->
                factDetailVM.loadFactDetail(backStackEntry.arguments?.getString("factId"))
                FactDetail(factDetailVM = factDetailVM)
            }
            composable(route = "home") {
                HomeCategories(homeVM = homeVM, navController = navController)
            }
            composable(route = "category") {
                HomeFacts(homeVM = homeVM, navController = navController)
            }
            composable(route = "settings") {
                SettingsView(settingsVM = settingsVM)
            }
        }
    }
}