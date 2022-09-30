package com.team23.facts23.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.facts23.R
import com.team23.facts23.presentation.viewmodels.AboutVM

@Composable
fun AboutView(aboutVM: AboutVM) {
    AboutView(
        buildVersion = aboutVM.buildVersion.value,
        onEmailClicked = { email -> aboutVM.launchEmailIntent(email) }
    )
}

@Composable
fun AboutView(buildVersion: String, onEmailClicked: (String) -> Unit) {
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
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp),
        )
        Text(
            text = stringResource(id = R.string.about_app_description),
        )
        Text(
            text = stringResource(id = R.string.about_contact_title),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp),
        )
        val spanStyle = SpanStyle(
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontFamily = MaterialTheme.typography.body1.fontFamily,
            fontStyle = MaterialTheme.typography.body1.fontStyle,
            fontWeight = MaterialTheme.typography.body1.fontWeight,
            letterSpacing = MaterialTheme.typography.body1.letterSpacing,
        )
        val annotatedText = buildAnnotatedString {
            withStyle(
                style = spanStyle
            ) {
                append("${stringResource(id = R.string.about_contact_description)} ")
            }
            pushStringAnnotation(
                tag = "mail",
                annotation = stringResource(id = R.string.about_contact_mail)
            )
            withStyle(
                style = spanStyle.copy(
                    color = MaterialTheme.colors.secondary,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                append(stringResource(id = R.string.about_contact_mail))
            }
            pop()
        }
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = "mail",
                    start = offset,
                    end = offset
                ).let {
                    if (it.isNotEmpty()) {
                        onEmailClicked(it[0].item)
                    }
                }
            }
        )
        Text(
            text = stringResource(id = R.string.about_version),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 0.dp),
        )
        Text(
            text = buildVersion,
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun AboutViewPreview() {
    AboutView(buildVersion = "2.3.0", onEmailClicked = { })
}