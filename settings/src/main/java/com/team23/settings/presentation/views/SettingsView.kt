package com.team23.settings.presentation.views

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        },
        onResetData = {
            settingsVM.onResetData()
        }
    )
}

@Composable
fun SettingsView(
    lastSelectedThemeMode: Int = 1,
    onThemeModeChanged: (Int) -> Unit = {},
    onLanguageChanged: (Int) -> Unit = {},
    onResetData: () -> Unit = {},
) {
    val openDialog = remember { mutableStateOf(false) }
    LazyColumn {
        // TODO CREATE VO AND USE ITEMS
        item {
            SettingsSection(
                title = stringResource(id = R.string.settings_theme_mode),
                values = listOf(
                    stringResource(id = R.string.settings_forced_dark_mode),
                    stringResource(id = R.string.settings_system_mode),
                    stringResource(id = R.string.settings_forced_light_mode),
                ),
                onValueChanged = onThemeModeChanged,
                lastSelectedValue = lastSelectedThemeMode,
            )
        }
        item {
            SettingsSection(
                title = stringResource(id = R.string.settings_colors),
                values = listOf(
                    stringResource(id = R.string.settings_colors_app),
                    stringResource(id = R.string.settings_colors_custom),
                ),
            )
        }
        item {
            SettingsSection(
                title = stringResource(id = R.string.settings_language),
                values = listOf(
                    stringResource(id = R.string.settings_language_english),
                    stringResource(id = R.string.settings_language_system),
                    stringResource(id = R.string.settings_language_french),
                ),
                onValueChanged = onLanguageChanged,
            )
        }
        item {
            SettingsSection(
                title = stringResource(id = R.string.settings_random),
                values = listOf(
                    stringResource(id = R.string.settings_random_pure),
                    stringResource(id = R.string.settings_random_unread),
                ),
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.settings_data),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Button(
                    onClick = { openDialog.value = true },
                    modifier = Modifier.padding(8.dp, 0.dp)
                ) {
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
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = { openDialog.value = false },
                    title = { Text(text = stringResource(id = R.string.settings_data_reset)) },
                    text = { Text(text = stringResource(id = R.string.settings_data_reset_description)) },
                    confirmButton = {
                        Button(
                            onClick = {
                                onResetData()
                                openDialog.value = false
                            }) {
                            Text(stringResource(id = R.string.settings_data_reset_confirm))
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = { openDialog.value = false }) {
                            Text(stringResource(id = R.string.settings_data_reset_dismiss))
                        }
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SettingsViewPreview() {
    SettingsView()
}