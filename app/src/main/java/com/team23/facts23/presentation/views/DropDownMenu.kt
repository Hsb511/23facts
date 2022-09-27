package com.team23.facts23.presentation.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.team23.core.domain.Screen
import com.team23.facts23.R

@Composable
fun DropDownMenu(isMenuExpanded: MutableState<Boolean>, navController: NavHostController) {
    DropdownMenu(
        expanded = isMenuExpanded.value,
        onDismissRequest = { isMenuExpanded.value = false },
        offset = DpOffset(x = 0.dp, y = 56.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        DropdownMenuItem(onClick = {
            isMenuExpanded.value = false
            navController.navigate(Screen.Settings().route)
        }) {
            Row {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "settings")
                Text(
                    text = stringResource(id = R.string.navigation_settings),
                    modifier = Modifier.padding(8.dp, 0.dp)
                )
            }
        }
        DropdownMenuItem(onClick = {
            isMenuExpanded.value = false
            navController.navigate(Screen.About().route)
        }) {
            Row {
                Icon(imageVector = Icons.Filled.Info, contentDescription = "info")
                Text(
                    text = stringResource(id = R.string.navigation_about),
                    modifier = Modifier.padding(8.dp, 0.dp)
                )
            }
        }
        DropdownMenuItem(onClick = {
            isMenuExpanded.value = false
            navController.navigate(Screen.Achievement().route)
        }) {
            Row {
                Icon(imageVector = Icons.Filled.Lock, contentDescription = "achievements")
                Text(
                    text = stringResource(id = R.string.navigation_achievements),
                    modifier = Modifier.padding(8.dp, 0.dp)
                )
            }
        }
    }
}