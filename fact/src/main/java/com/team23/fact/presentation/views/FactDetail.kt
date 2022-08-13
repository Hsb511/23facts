package com.team23.fact.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import com.team23.fact.presentation.viewobjects.FactDetailLinkVO
import com.team23.fact.presentation.viewobjects.FactDetailVO

@Composable
fun FactDetail(factDetailVO: FactDetailVO) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = factDetailVO.title,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        Text(
            text = factDetailVO.category,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
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
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(8.dp).fillMaxHeight()
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.fact_sources),
                    style = MaterialTheme.typography.body2
                )
            }
            items(factDetailVO.sources) {
                // TODO USE VM
                FactDetailLink(
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

@Preview(showSystemUi = true)
@Composable
fun FactDetailPreview() {
    FactDetail(
        FactDetailVO(
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