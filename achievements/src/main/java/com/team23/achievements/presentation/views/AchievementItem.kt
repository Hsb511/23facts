package com.team23.achievements.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.achievements.R
import com.team23.achievements.presentation.viewobjects.AchievementVO

@Composable
fun AchievementItem(achievement: AchievementVO) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.size(100.dp)
    ) {
        Text(
            text = stringResource(id = achievement.titleResId),
            style = MaterialTheme.typography.h6
        )
        if (achievement.unlockDate != null) {
            Image(
                painter = painterResource(id = achievement.imageResId),
                contentDescription = "achievement image",
                modifier = Modifier.size(46.dp)
            )
            Text(text = stringResource(id = achievement.messageResId))
            Text(
                text = stringResource(
                    id = R.string.achievements_unlocked_at,
                    achievement.unlockDate
                )
            )
        } else {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = "achievement locked",
                tint = MaterialTheme.colors.surface,
                modifier = Modifier.size(46.dp)
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