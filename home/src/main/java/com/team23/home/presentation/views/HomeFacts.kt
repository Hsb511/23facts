package com.team23.home.presentation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.team23.home.presentation.viewobjects.CategoryVO

@Composable
fun HomeFacts(navController: NavHostController = rememberNavController()) {
    val category = CategoryVO("MA", "Mathematics")
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = {
                    CategoryCodeBox(category = category)
                    Text(
                        text = category.title,
                        style = MaterialTheme.typography.h5,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.padding(4.dp, 0.dp, 8.dp, 0.dp)
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = MaterialTheme.colors.onPrimary,
                        modifier = Modifier
                            .padding(16.dp, 0.dp, 0.dp, 0.dp)
                            .clickable { navController.popBackStack() }
                    )
                }
            )

        },
        modifier = Modifier.padding(0.dp)
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {

        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun HomeFactsPreview() {
    HomeFacts()
}