package com.team23.search.presentation.mappers

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

@Composable
fun String.toAnnotatedString(searchText: String) = buildAnnotatedString {
    var newString = this@toAnnotatedString
    val indicesToKeep = newString.lowercase().split(searchText.lowercase()).map { it.length }
    indicesToKeep.forEachIndexed { index, value ->
        append(newString.substring(0, value))
        newString = newString.drop(value)
        if (index != indicesToKeep.size - 1) {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.secondaryVariant
                )
            ) {
                append(newString.substring(0, searchText.length))
                newString = newString.drop(searchText.length)
            }
        }

    }
}