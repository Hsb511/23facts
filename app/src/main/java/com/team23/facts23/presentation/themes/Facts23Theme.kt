package com.team23.facts23.presentation.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable

@Composable
fun Facts23Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors =  if (darkTheme) { darkColors() } else { lightColors() },
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}