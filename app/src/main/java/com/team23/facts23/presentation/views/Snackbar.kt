package com.team23.facts23.presentation.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.achievements.R
import com.team23.achievements.presentation.viewobjects.AchievementPreviewVO

@Composable
fun Snackbar(
    achievementPreview: AchievementPreviewVO,
    onSnackbarClicked: () -> Unit
) {
    Surface(
        elevation = 10.dp,
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(1.dp, MaterialTheme.colors.primary),
        modifier = Modifier
            .padding(8.dp)
            .clip(shape = MaterialTheme.shapes.large)
            .clickable(onClick = { onSnackbarClicked() })
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
                painter = painterResource(id = achievementPreview.imageResId),
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
                text = stringResource(id = achievementPreview.messageResId),
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SnackbarPreview() {
    Snackbar(
        achievementPreview = AchievementPreviewVO(
            imageResId = R.drawable.iconophile,
            messageResId = R.string.achievements_iconophile_message
        ), onSnackbarClicked = {}
    )
}