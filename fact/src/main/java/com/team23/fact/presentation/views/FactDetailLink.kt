package com.team23.fact.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.fact.R
import com.team23.fact.presentation.viewobjects.FactDetailLinkVO

@Composable
fun FactDetailLink(factDetailLinkVO: FactDetailLinkVO) {
    // TODO MAKE THE CARD CLICKABLE
    Card(
        elevation = 2.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            if (factDetailLinkVO.imageBitmap != null) {
                Image(
                    bitmap = factDetailLinkVO.imageBitmap,
                    contentDescription = stringResource(id = R.string.fact_link_image_description),
                    modifier = Modifier.size(60.dp)
                )
            } else {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = stringResource(id = R.string.fact_link_image_description),
                    modifier = Modifier.size(60.dp)
                )
            }
            Column(modifier = Modifier.padding(8.dp)) {
                if (factDetailLinkVO.title != null && factDetailLinkVO.domainName != null) {

                    Text(
                        text = factDetailLinkVO.title,
                        style = MaterialTheme.typography.body1
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

@Preview(showSystemUi = true)
@Composable
fun FactDetailLinkPreview() {
    FactDetailLink(
        FactDetailLinkVO(
            url = "https://en.wikipedia.org/wiki/Birthday_problem",
            imageBitmap = null,
            title = "The Birthday problem",
            domainName = "en.wikipedia.org"
        )
    )
}