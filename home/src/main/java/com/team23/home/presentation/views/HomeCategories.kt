package com.team23.home.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.home.presentation.viewmodels.HomeVM
import com.team23.home.presentation.viewobjects.CategoryVO

@Composable
fun HomeCategories(homeVM: HomeVM) {
    HomeCategories(homeVM.categories)
}

@Composable
fun HomeCategories(categories: List<CategoryVO>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(categories) {
            Box(
                modifier = Modifier
                    .padding(8.dp, 4.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = MaterialTheme.shapes.large
                    )
            )
            {
                Text(
                    text = it.title,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun HomeCategoriesPreview() {
    HomeCategories(
        listOf(
            CategoryVO("46", "Mathematics"),
            CategoryVO("69", "Physics & Chemistry"),
            CategoryVO("92", "Biology & Geology"),
            CategoryVO("115", "Computer Science"),
            CategoryVO("138", "Video Games")
        )
    )
}