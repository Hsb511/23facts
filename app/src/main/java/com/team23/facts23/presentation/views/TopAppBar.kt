package com.team23.facts23.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.team23.core.domain.Screen
import com.team23.facts23.R
import com.team23.home.presentation.CategoryCodeBox

@Composable
fun TopAppBar(
    screen: Screen,
    isMenuExpanded: MutableState<Boolean>,
    onBackPressed: () -> Unit,
    codeCategory: String?,
    nameCategory: String?,
    factId: String?,
    onAppIconClicked: () -> Unit,
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            if (screen is Screen.Home) {
                Image(
                    painter = painterResource(id = R.drawable.png_23facts_logo_transparent),
                    contentDescription = "23 facts logo",
                    modifier = Modifier
                        .height(60.dp)
                        .padding(4.dp, 0.dp)
                        .clickable { onAppIconClicked() }
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "back",
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .padding(16.dp, 0.dp, 0.dp, 0.dp)
                        .clickable { onBackPressed() }
                )
            }
        },
        title = {
            when (screen) {
                is Screen.Home -> {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                is Screen.Category -> {
                    if (codeCategory != null) {
                        CategoryCodeBox(category = codeCategory, inTopBar = true)
                    }
                    if (nameCategory != null) {
                        Text(
                            text = nameCategory,
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.padding(4.dp, 0.dp, 8.dp, 0.dp)
                        )
                    }
                }
                is Screen.Fact,
                is Screen.Random -> {
                    if (codeCategory != null) {
                        CategoryCodeBox(category = codeCategory, inTopBar = true)
                    }
                    if (nameCategory != null) {
                        Text(
                            text = nameCategory,
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.padding(4.dp, 0.dp, 8.dp, 0.dp)
                        )
                    }
                    if (factId != null) {
                        Text(
                            text = "#$factId",
                            style = MaterialTheme.typography.h6,
                            color = MaterialTheme.colors.onPrimary,
                        )
                    }
                }
                else -> {
                    Text(
                        text = stringResource(id = screen.title),
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { isMenuExpanded.value = !isMenuExpanded.value }) {
                Icon(
                    imageVector = if (isMenuExpanded.value) {
                        Icons.Filled.Close
                    } else {
                        Icons.Filled.Menu
                    },
                    contentDescription = "menu",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    )
}