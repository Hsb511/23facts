package com.team23.settings.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.settings.R
import com.team23.settings.presentation.viewmodels.SettingsVM

@Composable
fun SettingsView(settingsVM: SettingsVM) {
    SettingsView(
        lastSelectedThemeMode = when (settingsVM.isForcedDarkMode.value) {
            true -> 0
            null -> 1
            false -> 2
        },
        onThemeModeChanged = { selectedPosition ->
            settingsVM.onThemeModeChanged(
                selectedPosition
            )
        })
}

@Composable
fun SettingsView(
    lastSelectedThemeMode: Int = 1,
    onThemeModeChanged: (Int) -> Unit = {}
) {
    Column {
        Text(
            text = stringResource(id = R.string.settings_theme_mode),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
        SettingsSectionRadioButton(
            values = listOf(
                stringResource(id = R.string.settings_forced_dark_mode),
                stringResource(id = R.string.settings_system_mode),
                stringResource(id = R.string.settings_forced_light_mode),
            ),
            onValueChanged = onThemeModeChanged,
            lastSelectedValue = lastSelectedThemeMode,
        )
        Text(
            text = stringResource(id = R.string.settings_colors),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
        SettingsSectionRadioButton(
            values = listOf(
                stringResource(id = R.string.settings_colors_app),
                stringResource(id = R.string.settings_colors_custom),
            ),
            onValueChanged = {}
        )
        Text(
            text = stringResource(id = R.string.settings_language),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
        SettingsSectionRadioButton(
            values = listOf(
                stringResource(id = R.string.settings_language_english),
                stringResource(id = R.string.settings_language_system),
                stringResource(id = R.string.settings_language_french),
            ),
            onValueChanged = {}
        )
        Text(
            text = stringResource(id = R.string.settings_random),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
        SettingsSectionRadioButton(
            values = listOf(
                stringResource(id = R.string.settings_random_pure),
                stringResource(id = R.string.settings_random_unread),
            ),
            onValueChanged = {}
        )
        Text(
            text = stringResource(id = R.string.settings_data),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(8.dp)
        )
        Button(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp, 0.dp)) {
            Icon(
                imageVector = Icons.Outlined.Refresh,
                contentDescription = "reset"
            )
            Text(
                text = stringResource(id = R.string.settings_data_reset),
                modifier = Modifier.padding(8.dp, 0.dp)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SettingsViewPreview() {
    SettingsView()
}