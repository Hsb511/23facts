package com.team23.achievements.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.achievements.R
import com.team23.achievements.presentation.viewobjects.AchievementVO

@Composable
fun AchievementItem(achievement: AchievementVO) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = achievement.titleResId),
            style = MaterialTheme.typography.h4
        )
        val unlockDate = achievement.unlockDate
        if (unlockDate != null) {
            Text(
                text = stringResource(id = R.string.achievements_unlocked_at, unlockDate),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2
            )
            Image(
                painter = painterResource(id = achievement.imageResId),
                contentDescription = "achievement image",
                modifier = Modifier.size(92.dp).padding(4.dp)
            )
            Text(
                text = stringResource(id = achievement.messageResId),
                textAlign = TextAlign.Center,
            )
        } else {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = "achievement locked",
                tint = MaterialTheme.colors.surface,
                modifier = Modifier.size(92.dp).padding(4.dp)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun AchievementItemPreview() {
    AchievementItem(
        achievement = AchievementVO(
            titleResId = R.string.achievements_iconophile,
            imageResId = R.drawable.iconophile,
            messageResId = R.string.achievements_iconophile_message,
            unlockDate = "23/10/2022"
        )
    )
}