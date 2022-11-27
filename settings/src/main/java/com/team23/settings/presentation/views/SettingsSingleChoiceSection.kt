package com.team23.settings.presentation.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.settings.presentation.viewobjects.SettingsSingleChoiceVO
import com.team23.settings.R
@Composable
fun SettingsSingleChoiceSection(
    singleChoiceVO: SettingsSingleChoiceVO
) {
    if (singleChoiceVO.displayed) {
        Text(
            text = stringResource(id = singleChoiceVO.titleId),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
        singleChoiceVO.values.forEach { valueId ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                val currentPosition = singleChoiceVO.values.indexOf(valueId)
                RadioButton(
                    selected = singleChoiceVO.selectedValue.value == currentPosition,
                    enabled = !singleChoiceVO.disabled,
                    onClick = {
                        singleChoiceVO.onValueChanged(currentPosition)
                    })
                Text(
                    text = stringResource(id = valueId),
                    color = if (singleChoiceVO.disabled) {
                        MaterialTheme.colors.onSurface
                    } else {
                        MaterialTheme.colors.onBackground
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SettingsSingleChoiceSectionPreview() {
    SettingsSingleChoiceSection(
        SettingsSingleChoiceVO(
            titleId = R.string.settings_theme_mode,
            values = listOf(R.string.settings_forced_dark_mode, R.string.settings_system_mode, R.string.settings_forced_light_mode),
            onValueChanged = {},
            selectedValue = remember { mutableStateOf(1) },
            disabled = false
        )
    )
}