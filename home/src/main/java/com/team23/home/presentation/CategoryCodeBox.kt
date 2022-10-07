package com.team23.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.team23.home.presentation.extensions.getBackgroundColor
import com.team23.home.presentation.extensions.getTextColor

@Composable
fun CategoryCodeBox(category: String, inTopBar: Boolean = false, sizeChanger: Float = 1f) {
    val padding = if (inTopBar) {
        PaddingValues(0.dp, 4.dp, 4.dp, 4.dp)
    } else {
        PaddingValues(4.dp)
    }
    Box(
        modifier = Modifier
            .padding(padding)
            .size((sizeChanger * 42).dp)
            .background(
                color = category.getBackgroundColor(),
                shape = CircleShape
            )
    ) {
        Text(
            text = category,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2.copy(
                fontSize = (sizeChanger * MaterialTheme.typography.subtitle2.fontSize.value).sp
            ),
            color = category.getTextColor(),
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, (sizeChanger * 10).dp, 0.dp, 0.dp)
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun CategoryCodeBoxPreview() {
    CategoryCodeBox(category = "MA")
}