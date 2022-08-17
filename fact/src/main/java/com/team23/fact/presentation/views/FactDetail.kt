package com.team23.fact.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.team23.fact.R
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.fact.presentation.viewobjects.FactDetailLinkVO
import com.team23.fact.presentation.viewobjects.FactDetailVO

@Composable
fun FactDetail(factDetailVM: FactDetailVM) {
    FactDetail(
        factDetailVO = factDetailVM.factDetail.value,
        onShareFact = { /* TODO */ }
    )
}

@Composable
fun FactDetail(
    factDetailVO: FactDetailVO,
    onShareFact: () -> Unit = {}
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onShareFact() },
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Share,
                    contentDescription = stringResource(R.string.fact_icon_share),
                )
            }
        }) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = factDetailVO.title,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = factDetailVO.id,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = factDetailVO.category,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            if (factDetailVO.imageUrl != null) {
                Image(
                    painter = rememberAsyncImagePainter(factDetailVO.imageUrl),
                    contentDescription = stringResource(id = R.string.fact_image_description),
                    modifier = Modifier
                        .size(200.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
            } else if (factDetailVO.imageBitmap != null) {
                Image(
                    bitmap = factDetailVO.imageBitmap,
                    contentDescription = stringResource(id = R.string.fact_image_description),
                    modifier = Modifier
                        .size(200.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
            }
            Text(
                text = factDetailVO.description,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(8.dp)
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

            }
            LazyColumn(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
            ) {
                items(factDetailVO.sources) {
                    FactDetailLink(
                        // TODO USE VM
                        FactDetailLinkVO(
                            url = it,
                            title = "The Birthday paradox",
                            domainName = it.split("https://").get(1).split("/").get(0)
                        )
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun FactDetailPreview() {
    FactDetail(
        FactDetailVO(
            id = "#46",
            title = "The Birthday Paradox",
            category = "Mathematics",
            imageUrl = "https://images.unsplash.com/photo-1602631985686-1bb0e6a8696e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
            description = "The birthday paradox is that, counterintuitively, the probability of a shared birthday exceeds 50% in a group of only 23 people.",
            sources = listOf(
                "https://en.wikipedia.org/wiki/Birthday_problem",
                "https://pudding.cool/2018/04/birthday-paradox/",
                "https://betterexplained.com/articles/understanding-the-birthday-paradox/"
            )
        )
    )
}