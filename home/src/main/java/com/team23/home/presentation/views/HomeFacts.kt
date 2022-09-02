package com.team23.home.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.team23.home.R
import com.team23.home.presentation.viewmodels.HomeVM
import com.team23.home.presentation.viewobjects.CategoryVO
import com.team23.home.presentation.viewobjects.FactVO

@Composable
fun HomeFacts(homeVM: HomeVM, navController: NavHostController) {
    homeVM.selectedCategory.value?.let {
        HomeFacts(
            category = it,
            facts = homeVM.facts,
            onHomeReturn = {
                navController.popBackStack()
                homeVM.onReturnHome()
            },
            onFactClicked = { fact ->
                homeVM.onFactClicked(fact)
                navController.navigate("fact/${fact.id}")
            }
        )
    }
}

@Composable
fun HomeFacts(
    category: CategoryVO,
    facts: List<FactVO>,
    onHomeReturn: () -> Unit = {},
    onFactClicked: (FactVO) -> Unit = {}
) {
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
                            .clickable { onHomeReturn() }
                    )
                }
            )
        },
        modifier = Modifier.padding(0.dp)
    ) { padding ->
        LazyColumn(
            contentPadding = PaddingValues(4.dp),
            modifier = Modifier.padding(padding)
        ) {
            items(facts) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(4.dp, 4.dp, 12.dp, 4.dp)
                        .background(
                            color = MaterialTheme.colors.surface,
                            shape = MaterialTheme.shapes.large
                        )
                        .fillMaxWidth()
                        .height(50.dp)
                        .clickable { onFactClicked(it) }
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = if (it.picture.endsWith(".svg")) {
                                ImageRequest.Builder(LocalContext.current)
                                    .decoderFactory(SvgDecoder.Factory())
                                    .data(it.picture)
                                    .build()
                            } else {
                                it.picture
                            }
                        ),
                        contentDescription = stringResource(id = R.string.home_fact_picture),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                            .background(
                                color = Color.White,
                                shape = MaterialTheme.shapes.large.copy(
                                    topEnd = CornerSize(0.dp),
                                    bottomEnd = CornerSize(0.dp)
                                )
                            )
                            .clip(
                                shape = MaterialTheme.shapes.large.copy(
                                    topEnd = CornerSize(0.dp),
                                    bottomEnd = CornerSize(0.dp)
                                )
                            )
                    )
                    Text(
                        text = it.title,
                        style = MaterialTheme.typography.subtitle2,
                        color = MaterialTheme.colors.onSurface,
                        modifier = Modifier
                            .padding(8.dp, 0.dp)
                            .weight(0.9f)
                    )
                    if (it.new) {
                        Text(
                            text = stringResource(id = R.string.home_fact_new),
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier
                                .weight(0.2f)
                                .padding(8.dp, 0.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun HomeFactsPreview() {
    HomeFacts(
        category = CategoryVO("MA", "Mathematics"),
        facts = emptyList(),
    )
}