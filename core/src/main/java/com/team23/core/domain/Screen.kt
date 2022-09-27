package com.team23.core.domain

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.team23.core.R

sealed class Screen(val pageIndex: Int, val route: String, @StringRes val title: Int, val icon: ImageVector?) {
    class Home: Screen(0, "home", R.string.navigation_home, Icons.Default.Home)
    class Category: Screen(0, "category", R.string.navigation_categories, null)
    class Fact: Screen(0, "fact/{factId}", R.string.navigation_facts, null)
    class Random: Screen(1, "random",  R.string.navigation_random, Icons.Default.Refresh)
    class Search: Screen(2, "search", R.string.navigation_search, Icons.Default.Search)
    class Settings: Screen(3, "settings", R.string.navigation_settings, Icons.Filled.Settings)
    class About: Screen(4, "about", R.string.navigation_about, Icons.Filled.Info)
    class Achievement: Screen(5, "achievement", R.string.navigation_achievements, Icons.Filled.Lock)
}
