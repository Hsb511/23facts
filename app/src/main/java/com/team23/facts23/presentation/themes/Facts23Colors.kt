package com.team23.facts23.presentation.themes

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.team23.facts23.R

@Composable
fun light23FactsColors() = lightColors(
    primary = colorResource(id = R.color.liberty),
    primaryVariant = colorResource(id = R.color.prussian_blue),
    secondary = colorResource(id = R.color.may_green),
    secondaryVariant = colorResource(id = R.color.hunter_green),
    onSecondary = colorResource(id = R.color.white),
    surface = colorResource(id = R.color.platinum),
    onSurface = colorResource(id = R.color.eerie_black),
)

@Composable
fun dark23FactsColors() = darkColors(
    primary = colorResource(id = R.color.prussian_blue),
    primaryVariant = colorResource(id = R.color.liberty),
    onPrimary = Color.White,
    secondary = colorResource(id = R.color.hunter_green),
    secondaryVariant = colorResource(id = R.color.may_green),
    onSecondary = colorResource(id = R.color.white),
    surface = colorResource(id = R.color.eerie_black),
    onSurface = colorResource(id = R.color.platinum),
)