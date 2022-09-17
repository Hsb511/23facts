package com.team23.facts23.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.team23.achievements.presentation.viewobjects.AchievementVO

@Composable
fun SnackbarHost(achievement: AchievementVO, hostState: SnackbarHostState) {
    SnackbarHost(
        hostState = hostState,
        snackbar = {
            Surface(
                elevation = 10.dp, modifier = Modifier
                    .padding(8.dp)
                    .clip(shape = MaterialTheme.shapes.large)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colors.surface,
                            shape = MaterialTheme.shapes.large,
                        )
                ) {
                    Image(
                        painter = painterResource(id = achievement.imageResId),
                        contentDescription = "achievement image",
                        modifier = Modifier
                            .fillMaxHeight()
                            .clip(
                                shape = MaterialTheme.shapes.large.copy(
                                    topEnd = CornerSize(0.dp),
                                    bottomEnd = CornerSize(0.dp)
                                )
                            )
                    )
                    Text(
                        text = stringResource(id = achievement.messageResId),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    )
}