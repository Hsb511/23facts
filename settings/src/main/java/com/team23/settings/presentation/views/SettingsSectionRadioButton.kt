package com.team23.settings.presentation.views

import androidx.compose.foundation.layout.Row
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsSectionRadioButton(
    values: List<String>,
    onValueChanged: (Int) -> Unit,
    lastSelectedValue: Int = 1
) {
    var selectedPosition by remember { mutableStateOf(-1) }
    values.forEach {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val currentPosition = values.indexOf(it)
            val isValueSelected = if (selectedPosition == -1) {
                lastSelectedValue == currentPosition
            } else {
                selectedPosition == currentPosition
            }
            RadioButton(
                selected = isValueSelected,
                onClick = {
                    onValueChanged(currentPosition)
                    selectedPosition = currentPosition
                })
            Text(
                text = it
            )
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun TriStateTogglePreview() {
    SettingsSectionRadioButton(
        values = listOf("forced dark mode", "system setting", "forced light mode"),
        onValueChanged = {},
    )
}