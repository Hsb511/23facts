package com.team23.settings.domain.models

import com.team23.settings.R

enum class RandomnessType(val displayName: Int) {
    RANDOM_AMONG_ALL(R.string.settings_random_pure),
    RANDOM_AMONG_UNREAD(R.string.settings_random_unread)
}