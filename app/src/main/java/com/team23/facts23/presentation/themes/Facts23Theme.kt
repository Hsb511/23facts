package com.team23.facts23.presentation.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun Facts23Theme(
    darkTheme: Boolean?,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme ?: isSystemInDarkTheme()) {
            dark23FactsColors()
        } else {
            light23FactsColors()
        },
        typography = Facts23Typography,
        shapes = Facts23Shapes,
        content = content
    )
}