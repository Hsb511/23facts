package com.team23.facts23.presentation.views

import android.net.Uri
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
        onEmailClicked = { email -> aboutVM.launchEmailIntent(email) },
        onPrivacyPolicyClicked = { policy -> aboutVM.onPrivacyPolicyClicked(policy) }
    )
}

@Composable
fun AboutView(
    buildVersion: String,
    onEmailClicked: (String) -> Unit,
    onPrivacyPolicyClicked: (Uri) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        AboutViewAppSection()
        AboutViewContactSection(onEmailClicked)
        AboutViewPrivacySection(onPrivacyPolicyClicked)
        AboutViewVersionSection(buildVersion)
    }
}

@Composable
@Preview(showSystemUi = true)
fun AboutViewPreview() {
    AboutView(buildVersion = "2.3.0", onEmailClicked = { }, onPrivacyPolicyClicked = { })
}

@Composable
private fun AboutViewAppSection() {
    Column {
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
            modifier = Modifier.padding(0.dp, 8.dp),
        )
        Text(
            text = stringResource(id = R.string.about_app_description),
        )
    }
}

@Composable
private fun AboutViewContactSection(onEmailClicked: (String) -> Unit) {
    val mailTag = "mail"
    val spanStyle = SpanStyle(
        fontSize = MaterialTheme.typography.body1.fontSize,
        fontFamily = MaterialTheme.typography.body1.fontFamily,
        fontStyle = MaterialTheme.typography.body1.fontStyle,
        fontWeight = MaterialTheme.typography.body1.fontWeight,
        letterSpacing = MaterialTheme.typography.body1.letterSpacing,
    )
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = spanStyle.copy(color = MaterialTheme.colors.onBackground)
        ) {
            append("${stringResource(id = R.string.about_contact_description)} ")
        }
        pushStringAnnotation(
            tag = mailTag,
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

    Column {
        Text(
            text = stringResource(id = R.string.about_contact_title),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(0.dp, 8.dp),
        )
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = mailTag,
                    start = offset,
                    end = offset
                ).let {
                    if (it.isNotEmpty()) {
                        onEmailClicked(it[0].item)
                    }
                }
            }
        )
    }
}

@Composable
private fun AboutViewPrivacySection(onPrivacyPolicyClicked: (Uri) -> Unit) {
    val privacyPolicyTag = "policy"
    val spanStyle = SpanStyle(
        fontSize = MaterialTheme.typography.body1.fontSize,
        fontFamily = MaterialTheme.typography.body1.fontFamily,
        fontStyle = MaterialTheme.typography.body1.fontStyle,
        fontWeight = MaterialTheme.typography.body1.fontWeight,
        letterSpacing = MaterialTheme.typography.body1.letterSpacing,
    )
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = spanStyle.copy(color = MaterialTheme.colors.onBackground)
        ) {
            append("${stringResource(id = R.string.about_privacy_policy_read)} ")
        }
        pushStringAnnotation(
            tag = privacyPolicyTag,
            annotation = stringResource(id = R.string.about_privacy_policy_link)
        )
        withStyle(
            style = spanStyle.copy(
                color = MaterialTheme.colors.secondary,
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(stringResource(id = R.string.about_privacy_policy).lowercase())
        }
        pop()
    }

    Column {
        Text(
            text = stringResource(id = R.string.about_privacy_policy),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(0.dp, 8.dp),
        )
        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = privacyPolicyTag,
                    start = offset,
                    end = offset
                ).let {
                    if (it.isNotEmpty()) {
                        onPrivacyPolicyClicked(Uri.parse(it[0].item))
                    }
                }
            }
        )
    }
}

@Composable
private fun AboutViewVersionSection(buildVersion: String) {
    Text(
        text = stringResource(id = R.string.about_version),
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(0.dp, 8.dp),
    )
    Text(
        text = buildVersion,
    )
}