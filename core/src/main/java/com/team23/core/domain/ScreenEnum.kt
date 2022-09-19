package com.team23.core.domain

enum class ScreenEnum(val pageIndex: Int, val route: String) {
    HOME(0, "home"),
    CATEGORY(0, "category"),
    FACT(0, "fact/{factId}"),
    RANDOM(1, "random"),
    SEARCH(2, "search"),
    SETTINGS(3, "settings"),
    ABOUT(4, "about")
}