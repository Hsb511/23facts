package com.team23.achievements.presentation.viewconfiguration

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.platform.ViewConfiguration

@Composable
fun Unlock2ViewConfiguration(longPressTimeoutMillis: Long, content: @Composable () -> Unit) {
    fun ViewConfiguration.updateViewConfiguration() = object : ViewConfiguration {
        override val longPressTimeoutMillis: Long
            get() = longPressTimeoutMillis

        override val doubleTapTimeoutMillis: Long
            get() = this@updateViewConfiguration.doubleTapTimeoutMillis

        override val doubleTapMinTimeMillis: Long
            get() = this@updateViewConfiguration.doubleTapMinTimeMillis

        override val touchSlop: Float
            get() = this@updateViewConfiguration.touchSlop
    }

    CompositionLocalProvider(
        LocalViewConfiguration provides LocalViewConfiguration.current.updateViewConfiguration()
    ) {
        content()
    }
}