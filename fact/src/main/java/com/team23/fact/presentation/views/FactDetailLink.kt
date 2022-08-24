package com.team23.fact.presentation.views

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.team23.fact.R
import com.team23.fact.presentation.viewobjects.FactDetailLinkVO

@ExperimentalFoundationApi
@Composable
fun FactDetailLink(
    factDetailLinkVO: FactDetailLinkVO,
    onLinkClicked: (url: String) -> Unit = {},
    onLinkSaved: (url: String) -> Unit = {}
) {
    Box(modifier = Modifier.padding(4.dp)) {
        Card(
            elevation = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .combinedClickable(
                    onClick = { onLinkClicked(factDetailLinkVO.url) },
                    onLongClick = { onLinkSaved(factDetailLinkVO.url) },
                )
        ) {
            Row {
                if (factDetailLinkVO.image != null) {
                    Image(
                        painter = rememberAsyncImagePainter(factDetailLinkVO.image),
                        contentDescription = stringResource(id = R.string.fact_link_image_description),
                        modifier = Modifier
                            .height(60.dp)
                            .width(100.dp)
                            .background(color = Color.White)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_light_world_wide_web),
                        contentDescription = stringResource(id = R.string.fact_link_image_description),
                        tint = Color.Black,
                        modifier = Modifier
                            .height(60.dp)
                            .width(100.dp)
                            .background(color = Color.White)
                    )
                }
                Column(modifier = Modifier.padding(8.dp)) {
                    if (factDetailLinkVO.title != null && factDetailLinkVO.domainName != null) {

                        Text(
                            text = factDetailLinkVO.title,
                            style = MaterialTheme.typography.subtitle1
                        )
                        Text(
                            text = factDetailLinkVO.domainName,
                            style = MaterialTheme.typography.body2
                        )
                    } else {
                        Text(
                            text = factDetailLinkVO.url,
                            style = MaterialTheme.typography.body2
                        )
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Preview(showSystemUi = true)
@Composable
fun FactDetailLinkPreview() {
    FactDetailLink(
        FactDetailLinkVO(
            url = "https://en.wikipedia.org/wiki/Birthday_problem",
            image = null,
            title = "The Birthday problem",
            domainName = "en.wikipedia.org"
        )
    )
}