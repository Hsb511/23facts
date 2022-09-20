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
        ),
    )
)

private val titleFontFamily = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.orelgaone_regular,
            weight = FontWeight.W400,
            style = FontStyle.Normal
        )
    )
)


val Facts23Typography = Typography(
    h4 = TextStyle(
        fontFamily = titleFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        letterSpacing = 0.1.sp
    ),
    h6 = TextStyle(
        fontFamily = titleFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp,
        lineHeight = 15.sp
    ),
    body1 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.3.sp
    ),
    body2 = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
)