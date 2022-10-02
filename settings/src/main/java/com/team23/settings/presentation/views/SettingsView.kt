package com.team23.settings.presentation.views

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
    val isSystemInDarkTheme = isSystemInDarkTheme()
    SettingsView(
        lastSelectedThemeMode = 1,
        onThemeModeChanged = {
            settingsVM.themeModeSelectedValue.value = it
            settingsVM.isDarkMode.value = when (settingsVM.themeModeSelectedValue.value) {
                0 -> true
                2 -> false
                else -> isSystemInDarkTheme
            }
            settingsVM.onThemeModeChanged()
        },
        onLanguageChanged = {
            settingsVM.onLanguageChanged(it)
        }
    )
}

@Composable
fun SettingsView(
    lastSelectedThemeMode: Int = 1,
    onThemeModeChanged: (Int) -> Unit = {},
    onLanguageChanged: (Int) -> Unit = {},
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
            disabled = false,
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
            onValueChanged = onLanguageChanged
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
        Button(onClick = { /*TODO*/ }, enabled = false,  modifier = Modifier.padding(8.dp, 0.dp)) {
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