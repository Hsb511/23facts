package com.team23.facts23.presentation.views

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun NavigationLabel(
    @StringRes textResId: Int,
    selected: Boolean
) {
    Text(
        text = stringResource(id = textResId),
        color = if (selected) {
            MaterialTheme.colors.secondaryVariant
        } else {
            MaterialTheme.colors.onSurface
        },
        modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 0.dp)
    )
}