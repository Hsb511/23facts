package com.team23.settings.presentation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.settings.R
import com.team23.settings.presentation.viewmodels.SettingsVM

@Composable
fun SettingsView(settingsVM: SettingsVM) {
    SettingsView()
}

@Composable
fun SettingsView(

) {
    Column{
        Text(
            text = stringResource(id = R.string.settings_theme_mode),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(8.dp)
        )
        TriStateToggle(
            values = listOf(
                stringResource(id = R.string.settings_forced_dark_mode),
                stringResource(id = R.string.settings_system_mode),
                stringResource(id = R.string.settings_forced_light_mode),
            ),
            onValueChanged = {}
        )
        Text(
            text = stringResource(id = R.string.settings_language),
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(8.dp)
        )
        TriStateToggle(
            values = listOf(
                stringResource(id = R.string.settings_language_english),
                stringResource(id = R.string.settings_language_system),
                stringResource(id = R.string.settings_language_french),
            ),
            onValueChanged = {}
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun SettingsViewPreview() {
    SettingsView()
}