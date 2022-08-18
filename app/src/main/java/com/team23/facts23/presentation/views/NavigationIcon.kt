package com.team23.facts23.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun NavigationIcon(
    imageVector: ImageVector,
    descriptionResId: Int,
    selected: Boolean
) {
    Icon(
        imageVector = imageVector,
        contentDescription = stringResource(id = descriptionResId),
        tint = if (selected) {
            MaterialTheme.colors.secondaryVariant
        } else {
            MaterialTheme.colors.onSurface
        },
        modifier = Modifier
            .background(
                color = if (selected) {
                    MaterialTheme.colors.secondaryVariant.copy(alpha = 0.2f)
                } else {
                    MaterialTheme.colors.surface.copy(alpha = 0f)
                },
                shape = MaterialTheme.shapes.large
            )
            .padding(16.dp, 2.dp)
    )
}