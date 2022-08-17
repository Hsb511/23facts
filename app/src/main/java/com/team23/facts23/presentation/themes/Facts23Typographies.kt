package com.team23.facts23.presentation.themes

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.team23.facts23.R

private val appFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.opensans_light,
            weight = FontWeight.W300,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.opensans_lightitalic,
            weight = FontWeight.W300,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.opensans_medium,
            weight = FontWeight.W500,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.opensans_mediumitalic,
            weight = FontWeight.W500,
            style = FontStyle.Italic
        ),
        Font(
            resId = R.font.opensans_bold,
            weight = FontWeight.W700,
            style = FontStyle.Normal
        ),
        Font(
            resId = R.font.opensans_bolditalic,
            weight = FontWeight.W700,
            style = FontStyle.Italic
        )
    )
)

val Typography = Typography(
    h4 = TextStyle(
        fontFamily = appFontFamily,
    ),
    h6 = TextStyle(
        fontFamily = appFontFamily,
    ),
    subtitle1 = TextStyle(
        fontFamily = appFontFamily,
    ),
    body1 = TextStyle(
        fontFamily = appFontFamily,
    ),
)