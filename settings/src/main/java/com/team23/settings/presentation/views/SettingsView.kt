package com.team23.settings.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.team23.settings.presentation.viewobjects.SettingsSingleChoiceVO

@Composable
fun SettingsView(settingsVM: SettingsVM) {
    SettingsView(
        settingsSingleChoiceList = settingsVM.settingsSingleChoiceList,
        onResetData = { settingsVM.onResetData() }
    )
}

@Composable
fun SettingsView(
    settingsSingleChoiceList: List<SettingsSingleChoiceVO>,
    onResetData: () -> Unit,
) {
    val openDialog = remember { mutableStateOf(false) }
    LazyColumn {
        items(settingsSingleChoiceList) { singleChoice ->
            SettingsSingleChoiceSection(singleChoice)
        }
        item {
            Text(
                text = stringResource(id = R.string.settings_data),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
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
    SettingsView(
        settingsSingleChoiceList = listOf(
            SettingsSingleChoiceVO(
                titleId = R.string.settings_theme_mode,
                values = listOf(
                    R.string.settings_forced_dark_mode,
                    R.string.settings_system_mode,
                    R.string.settings_forced_light_mode,
                ),
                onValueChanged = { },
                lastSelectedValue = 1,
            ),
            SettingsSingleChoiceVO(
                titleId = R.string.settings_colors,
                values = listOf(
                    R.string.settings_colors_app,
                    R.string.settings_colors_custom,
                ),
                onValueChanged = { },
                lastSelectedValue = 0,
            ),
            SettingsSingleChoiceVO(
                titleId = R.string.settings_random,
                values = listOf(
                    R.string.settings_random_pure,
                    R.string.settings_random_unread,
                ),
                onValueChanged = { },
                lastSelectedValue = 0,
            )
        ),
        onResetData = {},
    )
}