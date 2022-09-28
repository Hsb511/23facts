package com.team23.facts23.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.facts23.R

@Composable
fun AboutView() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h4,
            modifier = Modifier.align(CenterHorizontally)
        )
        Image(
            painter = painterResource(id = R.drawable.png_23facts_logo),
            contentDescription = "23 facts logo",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .height(69.dp)
                .align(CenterHorizontally)
        )
        Text(
            text = stringResource(id = R.string.about_app_title),
            style = MaterialTheme.typography.h5
        )
        Text(
            text = stringResource(id = R.string.about_app_description),
        )
        Text(
            text = stringResource(id = R.string.about_contact_title),
            style = MaterialTheme.typography.h5
        )
        Text(
            text = stringResource(id = R.string.about_contact_description),
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun AboutViewPreview() {
    AboutView()
}