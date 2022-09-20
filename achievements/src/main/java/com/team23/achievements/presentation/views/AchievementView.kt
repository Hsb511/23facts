package com.team23.achievements.presentation.views

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.achievements.presentation.viewmodels.AchievementVM
import com.team23.achievements.presentation.viewobjects.AchievementVO

@Composable
fun AchievementView(achievementVM: AchievementVM) {
    AchievementView(achievements = achievementVM.achievements)
}

@Composable
fun AchievementView(achievements: List<AchievementVO>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(achievements) { achievement ->
            AchievementItem(achievement = achievement)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun AchievementPreview() {
    AchievementView(
        achievements = emptyList()
    )
}