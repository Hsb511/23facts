package com.team23.facts23.presentation.views


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.team23.facts23.R

@Composable
fun BottomAppBar(
    onNavigateHome: () -> Unit,
    onNavigateRandom: () -> Unit,
    onNavigateSearch: () -> Unit,
    onNavigateSettings: () -> Unit
) {

    val selectedIndex = remember { mutableStateOf(0) }

    BottomAppBar(contentPadding = PaddingValues(0.dp, 0.dp)) {
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
                    onNavigateHome()
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
                    onNavigateRandom()
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
                    onNavigateSearch()
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
                    onNavigateSettings()
                }
            )
        }
    }
}

