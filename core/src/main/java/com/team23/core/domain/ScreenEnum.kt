package com.team23.core.domain

enum class ScreenEnum(val route: String) {
    HOME("home"),
    CATEGORY("category"),
    FACT("fact/{factId}"),
    RANDOM("random"),
    SETTINGS("settings")
}