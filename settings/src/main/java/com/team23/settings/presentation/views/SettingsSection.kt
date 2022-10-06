package com.team23.settings.presentation.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsSection(
    title: String,
    values: List<String>,
    onValueChanged: (Int) -> Unit = {},
    lastSelectedValue: Int = 1,
) {
    Text(
        text = title,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(8.dp)
    )
    SettingsSectionRadioButton(
        values = values,
        onValueChanged = onValueChanged,
        lastSelectedValue = lastSelectedValue,
        disabled = false,
    )
}