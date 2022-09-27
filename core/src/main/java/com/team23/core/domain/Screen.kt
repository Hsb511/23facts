package com.team23.core.domain

import androidx.annotation.StringRes
import com.team23.core.R

sealed class Screen(val pageIndex: Int, val route: String, @StringRes val title: Int) {
    class Home: Screen(0, "home", R.string.navigation_home)
    class Category: Screen(0, "category", R.string.navigation_categories)
    class Fact: Screen(0, "fact/{factId}", R.string.navigation_facts)
    class Random: Screen(1, "random",  R.string.navigation_random)
    class Search: Screen(2, "search", R.string.navigation_search)
    class Settings: Screen(3, "settings", R.string.navigation_search)
    class About: Screen(4, "about", R.string.navigation_about)
    class Achievement: Screen(5, "achievement", R.string.navigation_achievements)
}
