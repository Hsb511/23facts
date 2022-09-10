package com.team23.facts23.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.team23.core.domain.ScreenEnum
import com.team23.facts23.R
import com.team23.home.presentation.CategoryCodeBox

@Composable
fun TopAppBar(
    screen: ScreenEnum,
    onBackPressed: () -> Unit,
    codeCategory: String?,
    nameCategory: String?,
    factId: String?
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            when (screen) {
                ScreenEnum.HOME -> Icon(
                    imageVector = Icons.Filled.Face, // TODO
                    contentDescription = "23 facts logo",
                    tint = MaterialTheme.colors.onPrimary,
                    modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp)
                )
                ScreenEnum.CATEGORY,
                ScreenEnum.FACT,
                ScreenEnum.SETTINGS,
                ScreenEnum.RANDOM -> Icon(
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
                ScreenEnum.HOME -> {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                ScreenEnum.CATEGORY -> {
                    if (codeCategory != null) {
                        CategoryCodeBox(category = codeCategory)
                    }
                    if (nameCategory != null) {
                        Text(
                            text = nameCategory,
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.padding(4.dp, 0.dp, 8.dp, 0.dp)
                        )
                    }
                }
                ScreenEnum.FACT,
                ScreenEnum.RANDOM -> {
                    if (codeCategory != null) {
                        CategoryCodeBox(category = codeCategory)
                    }
                    if (nameCategory != null) {
                        Text(
                            text = nameCategory,
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.padding(4.dp, 0.dp, 8.dp, 0.dp)
                        )
                    }
                    if (factId != null) {
                        Text(
                            text = "#$factId",
                            style = MaterialTheme.typography.h5,
                            color = MaterialTheme.colors.onPrimary,
                        )
                    }
                }
                ScreenEnum.SETTINGS -> {
                    Text(
                        text = stringResource(id = R.string.navigation_settings),
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
            }
        }
    )
}