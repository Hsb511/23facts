package com.team23.home.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.team23.home.R
import com.team23.home.presentation.viewmodels.HomeVM
import com.team23.home.presentation.viewobjects.CategoryVO

@Composable
fun HomeCategories(homeVM: HomeVM, navController: NavHostController) {
    HomeCategories(
        categories = homeVM.categories,
        onCategoryClicked = { navController.navigate("category") }
    )
}

@Composable
fun HomeCategories(
    categories: List<CategoryVO>,
    onCategoryClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = {
                    Text(
                        text = stringResource(id = R.string.home_categories_title),
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = MaterialTheme.colors.primary,
                    )
                }
            )

        },
        modifier = Modifier.padding(0.dp)
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier.padding(padding)
        ) {
            items(categories) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(4.dp)
                        .background(
                            color = MaterialTheme.colors.surface,
                            shape = MaterialTheme.shapes.large
                        )
                        .height(50.dp)
                        .clickable {
                            onCategoryClicked()
                        }
                ) {
                    CategoryCodeBox(category = it)
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
        categories = listOf(
            CategoryVO("MA", "Mathematics"),
            CategoryVO("PC", "Physics & Chemistry"),
            CategoryVO("BG", "Biology & Geology"),
            CategoryVO("CS", "Computer Science"),
            CategoryVO("VG", "Video Games")
        ),
        onCategoryClicked = {}
    )
}