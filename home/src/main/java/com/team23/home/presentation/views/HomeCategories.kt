package com.team23.home.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.home.R
import com.team23.home.presentation.extensions.getBackgroundColor
import com.team23.home.presentation.extensions.getTextColor
import com.team23.home.presentation.viewmodels.HomeVM
import com.team23.home.presentation.viewobjects.CategoryVO

@Composable
fun HomeCategories(homeVM: HomeVM) {
    HomeCategories(homeVM.categories)
}

@Composable
fun HomeCategories(categories: List<CategoryVO>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.home_categories_title),
                        style = MaterialTheme.typography.h5
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = MaterialTheme.colors.primarySurface,
                    )
                }
            )

        },
        modifier = Modifier.padding(0.dp)
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(padding)
        ) {
            items(categories) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(8.dp, 4.dp, 4.dp, 4.dp)
                        .background(
                            color = MaterialTheme.colors.surface,
                            shape = MaterialTheme.shapes.large
                        )
                        .height(50.dp)

                ) {
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .size(46.dp)
                            .background(
                                color = it.getBackgroundColor(),
                                shape = CircleShape
                            )
                    ) {
                        Text(
                            text = it.code,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.subtitle2,
                            color = it.getTextColor(),
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(0.dp, 10.dp, 0.dp, 0.dp)
                        )
                    }
                    Text(
                        text = it.title,
                        style = MaterialTheme.typography.subtitle2,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier.padding(4.dp, 0.dp, 8.dp, 0.dp)
                    )
                }
            }
        }
    }

}

@Composable
@Preview(showSystemUi = true)
fun HomeCategoriesPreview() {
    HomeCategories(
        listOf(
            CategoryVO("MA", "Mathematics"),
            CategoryVO("PC", "Physics & Chemistry"),
            CategoryVO("BG", "Biology & Geology"),
            CategoryVO("CS", "Computer Science"),
            CategoryVO("VG", "Video Games")
        )
    )
}