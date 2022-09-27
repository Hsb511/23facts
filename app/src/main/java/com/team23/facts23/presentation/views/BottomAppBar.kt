package com.team23.facts23.presentation.views


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.team23.core.domain.Screen

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
            listOf(Screen.Home(), Screen.Random(), Screen.Search()).forEach { screen ->
                val isSelected = pageIndex == screen.pageIndex
                BottomNavigationItem(
                    icon = {
                        NavigationIcon(
                            imageVector = screen.icon!!,
                            descriptionResId = screen.title,
                            selected = isSelected,
                        )
                    },
                    label = {
                        NavigationLabel(
                            textResId = screen.title,
                            selected = isSelected,
                        )
                    },
                    selected = isSelected,
                    selectedContentColor = MaterialTheme.colors.secondaryVariant,
                    onClick = {
                        when (screen) {
                            is Screen.Home -> onNavigateHome()
                            is Screen.Random -> onNavigateRandom()
                            is Screen.Search -> onNavigateSearch()
                            else -> {}
                        }
                    }
                )
            }
        }
    }
}

