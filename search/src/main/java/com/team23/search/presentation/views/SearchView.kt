package com.team23.search.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.team23.search.presentation.mappers.toAnnotatedString
import com.team23.search.presentation.viewmodels.SearchVM
import com.team23.search.presentation.viewobjects.FactPreviewVO

@Composable
fun SearchView(searchVM: SearchVM, navController: NavHostController) {
    SearchView(
        searchText = searchVM.searchText,
        onSearchChanged = { value -> searchVM.onTextChanged(value) },
        foundFacts = searchVM.facts,
        onFactClicked = { factId -> navController.navigate("fact/$factId") }
    )
}

@Composable
fun SearchView(
    searchText: MutableState<String>,
    onSearchChanged: (value: String) -> Unit,
    foundFacts: List<FactPreviewVO>,
    onFactClicked: (Long) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = searchText.value,
            onValueChange = {
                onSearchChanged(it)
                searchText.value = it
            },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(foundFacts) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.surface,
                            shape = MaterialTheme.shapes.large
                        )
                        .fillMaxWidth()
                        .height(69.dp)
                        .clickable { onFactClicked(it.id) }
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            model = if (it.imageUrl.endsWith(".svg")) {
                                ImageRequest.Builder(LocalContext.current)
                                    .decoderFactory(SvgDecoder.Factory())
                                    .data(it.imageUrl)
                                    .build()
                            } else {
                                it.imageUrl
                            }
                        ),
                        contentDescription = "fact image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(69.dp)
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
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = it.title.toAnnotatedString(searchText = searchText.value),
                            style = MaterialTheme.typography.subtitle2,
                            color = MaterialTheme.colors.onSurface,
                            maxLines = 1,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp, 0.dp)
                        )
                        Text(
                            text = it.text.toAnnotatedString(searchText = searchText.value),
                            style = MaterialTheme.typography.body2,
                            color = MaterialTheme.colors.onSurface,
                            lineHeight = 13.sp,
                            maxLines = 3,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(8.dp, 0.dp)
                        )
                    }

                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SearchPreview() {
    SearchView(
        searchText = remember { mutableStateOf("mathémati") },
        onSearchChanged = { },
        foundFacts = listOf(
            FactPreviewVO(
                id = 23L,
                imageUrl = "https://images.unsplash.com/photo-1602631985686-1bb0e6a8696e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                title = "Le Paradoxe des Anniversaires",
                text = "Dans une pièce où se trouvent 23 personnes, il y a une chance sur deux qu''au moins deux"
            ),
            FactPreviewVO(
                id = 46L,
                imageUrl = "https://miro.medium.com/max/1400/1*ahy12g2hFP21x7YolyQ_Ug.jpeg",
                title = "Les problèmes de Hilbert",
                text = "Le 8 août 1900, à l''occasion du second Congrès International des mathématiciens à la Sorbonne"
            )
        ),
        onFactClicked = {}
    )
}