package com.team23.fact.presentation.views

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.team23.fact.R
import com.team23.fact.presentation.viewmodels.FactDetailVM
import com.team23.fact.presentation.viewobjects.CategoryVO
import com.team23.fact.presentation.viewobjects.FactDetailLinkVO
import com.team23.fact.presentation.viewobjects.FactDetailVO


@ExperimentalFoundationApi
@Composable
fun FactDetail(factDetailVM: FactDetailVM) {
    val context = LocalContext.current
    val clipboardManager = LocalClipboardManager.current
    val toastMessage = stringResource(R.string.fact_link_url_saved)
    FactDetail(
        factDetailVO = factDetailVM.factDetail.value,
        factSources = factDetailVM.factSources,
        onShareFact = { factDetailVM.onShareFact() },
        onClickLink = { url ->
            startActivity(context, Intent(Intent.ACTION_VIEW, Uri.parse(url)), null)
        },
        onLongClickLink = { url ->
            clipboardManager.setText(AnnotatedString(url))
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
        }
    )
}

@ExperimentalFoundationApi
@Composable
fun FactDetail(
    factDetailVO: FactDetailVO?,
    factSources: List<FactDetailLinkVO?>,
    onShareFact: () -> Unit = {},
    onClickLink: (url: String) -> Unit = {},
    onLongClickLink: (url: String) -> Unit = {},
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when {
                factDetailVO == null -> {
                    CircularProgressIndicator(
                        strokeWidth = 11.5.dp,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(115.dp)
                    )
                }
                factDetailVO.id == "#null" -> {
                    Text(
                        text = stringResource(id = R.string.fact_all_facts_read),
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp)
                    )
                }
                else -> {
                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        item {
                            Text(
                                text = factDetailVO.title,
                                style = MaterialTheme.typography.h4,
                                color = MaterialTheme.colors.onBackground,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .fillMaxWidth()
                            )
                        }
                        item {
                            if (factDetailVO.imageUrl != null) {
                                Image(
                                    painter = if (factDetailVO.imageUrl.endsWith(".svg")) {
                                        rememberAsyncImagePainter(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .decoderFactory(SvgDecoder.Factory())
                                                .data(factDetailVO.imageUrl)
                                                .build()
                                        )
                                    } else {
                                        rememberAsyncImagePainter(factDetailVO.imageUrl)
                                    },
                                    contentDescription = stringResource(id = R.string.fact_image_description),
                                    modifier = Modifier
                                        .widthIn(0.dp, 300.dp)
                                        .heightIn(100.dp, 200.dp)
                                        .clip(MaterialTheme.shapes.medium)
                                        .padding(8.dp)
                                        .background(
                                            color = Color.White,
                                            shape = MaterialTheme.shapes.medium
                                        )
                                )
                            } else if (factDetailVO.imageBitmap != null) {
                                Image(
                                    bitmap = factDetailVO.imageBitmap,
                                    contentDescription = stringResource(id = R.string.fact_image_description),
                                    modifier = Modifier
                                        .widthIn(0.dp, 300.dp)
                                        .heightIn(0.dp, 200.dp)
                                        .clip(MaterialTheme.shapes.medium)
                                        .padding(8.dp)
                                        .background(
                                            color = Color.White,
                                            shape = MaterialTheme.shapes.medium
                                        )
                                )
                            }
                        }
                        item {
                            Text(
                                text = factDetailVO.description,
                                style = MaterialTheme.typography.body1,
                                color = MaterialTheme.colors.onBackground,
                                modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 16.dp)
                            )
                        }
                        if (factSources.contains(null)) {
                            item {
                                CircularProgressIndicator(
                                    strokeWidth = 11.5.dp,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .size(115.dp)
                                )
                            }
                        } else {
                            items(factSources.filterNotNull()) {
                                FactDetailLink(
                                    factDetailLinkVO = it,
                                    onLinkClicked = { url -> onClickLink(url) },
                                    onLinkSaved = { url -> onLongClickLink(url) },
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}

@ExperimentalFoundationApi
@Preview(showSystemUi = true)
@Composable
fun FactDetailPreview() {
    FactDetail(
        FactDetailVO(
            id = "#46",
            title = "The Birthday Paradox",
            category = CategoryVO(
                code = "MA",
                name = "Mathematics",
                shortName = "Mathematics",
            ),
            imageUrl = "https://images.unsplash.com/photo-1602631985686-1bb0e6a8696e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
            description = "The birthday paradox is that, counterintuitively, the probability of a shared birthday exceeds 50% in a group of only 23 people.",
        ),
        factSources = listOf(
            FactDetailLinkVO(
                url = "https://pudding.cool/2018/04/birthday-paradox/",
                title = "The Birthday paradox",
                domainName = "pudding.cool"
            ),
            FactDetailLinkVO(
                url = "https://betterexplained.com/articles/understanding-the-birthday-paradox/",
                title = "The Birthday paradox",
                domainName = "betterexplained.com"
            ),
        )
    )
}