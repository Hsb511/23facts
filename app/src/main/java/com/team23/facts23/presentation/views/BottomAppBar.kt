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
import androidx.compose.ui.unit.dp
import com.team23.core.domain.ScreenEnum
import com.team23.facts23.R

@Composable
fun BottomAppBar(
    pageIndex: Int,
    onNavigateHome: () -> Unit,
    onNavigateRandom: () -> Unit,
    onNavigateSearch: () -> Unit,
) {


    BottomAppBar(contentPadding = PaddingValues(0.dp, 0.dp)) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.surface
        ) {
            BottomNavigationItem(
                icon = {
                    NavigationIcon(
                        imageVector = Icons.Default.Home,
                        descriptionResId = R.string.navigation_home,
                        selected = pageIndex == ScreenEnum.HOME.pageIndex
                    )
                },
                label = {
                    NavigationLabel(
                        textResId = R.string.navigation_home,
                        selected = pageIndex == ScreenEnum.HOME.pageIndex,
                    )
                },
                selected = (pageIndex == ScreenEnum.HOME.pageIndex),
                selectedContentColor = MaterialTheme.colors.secondaryVariant,
                onClick = { onNavigateHome() }
            )
            BottomNavigationItem(
                icon = {
                    NavigationIcon(
                        imageVector = Icons.Default.Refresh,
                        descriptionResId = R.string.navigation_random,
                        selected = pageIndex == ScreenEnum.RANDOM.pageIndex
                    )
                },
                label = {
                    NavigationLabel(
                        textResId = R.string.navigation_random,
                        selected = pageIndex == ScreenEnum.RANDOM.pageIndex,
                    )
                },
                selected = (pageIndex == ScreenEnum.RANDOM.pageIndex),
                selectedContentColor = MaterialTheme.colors.secondaryVariant,
                onClick = { onNavigateRandom() },
            )
            BottomNavigationItem(
                icon = {
                    NavigationIcon(
                        imageVector = Icons.Default.Search,
                        descriptionResId = R.string.navigation_search,
                        selected = pageIndex == ScreenEnum.SEARCH.pageIndex
                    )
                },
                label = {
                    NavigationLabel(
                        textResId = R.string.navigation_search,
                        selected = pageIndex == ScreenEnum.SEARCH.pageIndex,
                    )
                },
                selected = (pageIndex == ScreenEnum.SEARCH.pageIndex),
                onClick = { onNavigateSearch() }
            )
        }
    }
}

