package com.team23.facts23.presentation.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable

@Composable
fun Facts23Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) { dark23FactsColors() } else { light23FactsColors() },
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}