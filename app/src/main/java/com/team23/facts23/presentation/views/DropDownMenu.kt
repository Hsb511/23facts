package com.team23.facts23.presentation.views

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.team23.core.domain.Screen

@Composable
fun DropDownMenu(isMenuExpanded: MutableState<Boolean>, onNavigate: (Screen) -> Unit) {
    DropdownMenu(
        expanded = isMenuExpanded.value,
        onDismissRequest = { isMenuExpanded.value = false },
        offset = DpOffset(x = 0.dp, y = 56.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        listOf(Screen.Settings(), Screen.Achievement(), Screen.About()).forEach { screen ->
            DropdownMenuItem(onClick = {
                isMenuExpanded.value = false
                onNavigate(screen)
            }) {
                Row {
                    Icon(
                        imageVector = screen.icon!!,
                        contentDescription = stringResource(id = screen.title)
                    )
                    Text(
                        text = stringResource(id = screen.title),
                        modifier = Modifier.padding(8.dp, 0.dp)
                    )
                }
            }
        }
    }
}