package com.team23.facts23.presentation.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.fact.presentation.views.FactDetail
import com.team23.facts23.R
import com.team23.home.presentation.viewmodels.HomeVM
import com.team23.home.presentation.views.HomeCategories

@ExperimentalFoundationApi
@Composable
fun NavigationView(factDetailVM: FactDetailVM, homeVM: HomeVM) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomAppBar(contentPadding = PaddingValues(0.dp, 0.dp)) {
                val selectedIndex = remember { mutableStateOf(1) }
                BottomNavigation(
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    BottomNavigationItem(
                        icon = {
                            NavigationIcon(
                                imageVector = Icons.Default.Home,
                                descriptionResId = R.string.navigation_home,
                                selected = selectedIndex.value == 0
                            )
                        },
                        label = {
                            NavigationLabel(
                                textResId = R.string.navigation_home,
                                selected = selectedIndex.value == 0,
                            )
                        },
                        selected = (selectedIndex.value == 0),
                        selectedContentColor = MaterialTheme.colors.secondaryVariant,
                        onClick = {
                            selectedIndex.value = 0
                            navController.navigate("home")
                        }
                    )
                    BottomNavigationItem(
                        icon = {
                            NavigationIcon(
                                imageVector = Icons.Default.Refresh,
                                descriptionResId = R.string.navigation_random,
                                selected = selectedIndex.value == 1
                            )
                        },
                        label = {
                            NavigationLabel(
                                textResId = R.string.navigation_random,
                                selected = selectedIndex.value == 1,
                            )
                        },
                        selected = (selectedIndex.value == 1),
                        selectedContentColor = MaterialTheme.colors.secondaryVariant,
                        onClick = {
                            selectedIndex.value = 1
                            navController.navigate("random")
                        },
                    )
                    BottomNavigationItem(
                        icon = {
                            NavigationIcon(
                                imageVector = Icons.Default.Search,
                                descriptionResId = R.string.navigation_search,
                                selected = selectedIndex.value == 2
                            )
                        },
                        label = {
                            NavigationLabel(
                                textResId = R.string.navigation_search,
                                selected = selectedIndex.value == 2,
                            )
                        },
                        selected = (selectedIndex.value == 2),
                        onClick = {
                            selectedIndex.value = 2
                            // TODO
                        }
                    )
                    BottomNavigationItem(
                        icon = {
                            NavigationIcon(
                                imageVector = Icons.Default.Settings,
                                descriptionResId = R.string.navigation_settings,
                                selected = selectedIndex.value == 3
                            )
                        },
                        label = {
                            NavigationLabel(
                                textResId = R.string.navigation_settings,
                                selected = selectedIndex.value == 3,
                            )
                        },
                        selected = (selectedIndex.value == 3),
                        onClick = {
                            selectedIndex.value = 3
                            // TODO
                        }
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "random",
            modifier = Modifier.padding(padding)
        ) {
            composable(route = "random") {
                FactDetail(factDetailVM = factDetailVM)
            }
            composable(route = "home") {
                HomeCategories(homeVM = homeVM)
            }
        }
    }
}