package com.team23.settings.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TriStateToggle(
    values: List<String>,
    onValueChanged: (Int) -> Unit
) {
    var selectedPosition by remember { mutableStateOf(0) }

    Surface(
        shape = MaterialTheme.shapes.large,
        elevation = 4.dp,
        modifier = Modifier.wrapContentSize()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .clip(shape = MaterialTheme.shapes.large)
                .background(color = MaterialTheme.colors.surface)
                .fillMaxWidth()
        ) {
            values.forEach {
                val isValueSelected = selectedPosition == values.indexOf(it)
                Text(
                    text = it,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    color = if (isValueSelected) {
                        MaterialTheme.colors.onSecondary
                    } else {
                        MaterialTheme.colors.onSurface
                    },
                    modifier = Modifier
                        .clip(shape = MaterialTheme.shapes.large)
                        .clickable {
                            val newPosition = values.indexOf(it)
                            onValueChanged(newPosition)
                            selectedPosition = newPosition
                        }
                        .background(
                            color = if (isValueSelected) {
                                MaterialTheme.colors.secondaryVariant
                            } else {
                                MaterialTheme.colors.surface
                            }
                        )
                        .padding(12.dp, 12.dp)
                        .weight(1f)
                        .height(48.dp)
                        .align(Alignment.CenterVertically)
                )
            }

        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun TriStateTogglePreview() {
    TriStateToggle(
        values = listOf("forced dark mode", "system setting", "forced light mode"),
        onValueChanged = {},
    )
}