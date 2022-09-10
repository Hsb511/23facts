package com.team23.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.team23.home.presentation.extensions.getBackgroundColor
import com.team23.home.presentation.extensions.getTextColor

@Composable
fun CategoryCodeBox(category: String) {
    Box(
        modifier = Modifier
            .padding(4.dp)
            .size(42.dp)
            .background(
                color = category.getBackgroundColor(),
                shape = CircleShape
            )
    ) {
        Text(
            text = category,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2,
            color = category.getTextColor(),
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 10.dp, 0.dp, 0.dp)
        )
    }
}

@Composable
@Preview(showSystemUi = true)
fun CategoryCodeBoxPreview() {
    CategoryCodeBox(category = "MA")
}