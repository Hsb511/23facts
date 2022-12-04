package com.team23.settings.domain.models

import com.team23.settings.R

enum class ThemeMode(val displayName: Int) {
    DARK_MODE(R.string.settings_forced_dark_mode),
    SYSTEM_SETTINGS_MODE(R.string.settings_system_mode),
    LIGHT_MODE(R.string.settings_forced_light_mode),
}