package com.team23.home.presentation.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.team23.home.R
import com.team23.home.presentation.viewobjects.CategoryVO

@Composable
fun CategoryVO.getBackgroundColor() = when(this.code) {
    "MA" -> colorResource(id = R.color.persian_red)
    "PC" -> colorResource(id = R.color.imperial_red)
    "BG" -> colorResource(id = R.color.spanish_orange)
    "ME" -> colorResource(id = R.color.copper_crayola)
    "CS" -> colorResource(id = R.color.orange_yellow)
    "VG" -> colorResource(id = R.color.citrine)
    "MU" -> colorResource(id = R.color.yellow_green)
    "MS" -> colorResource(id = R.color.green_ryb)
    "AL" -> colorResource(id = R.color.may_green)
    "GF" -> colorResource(id = R.color.hunter_green)
    "HI" -> colorResource(id = R.color.persian_green)
    "GE" -> colorResource(id = R.color.caribbean_green)
    "FE" -> colorResource(id = R.color.han_blue)
    "IB" -> colorResource(id = R.color.liberty)
    "AT" -> colorResource(id = R.color.persian_indigo)
    "AM" -> colorResource(id = R.color.prussian_blue)
    "SH" -> colorResource(id = R.color.russian_violet)
    "RN" -> colorResource(id = R.color.razzmic_berry)
    "RM" -> colorResource(id = R.color.irresitible)
    "BD" -> colorResource(id = R.color.english_lavender)
    "PL" -> colorResource(id = R.color.davys_grey)
    "SM" -> colorResource(id = R.color.battleship_grey)
    "OT" -> colorResource(id = R.color.sepia)
    else -> Color.White
}

@Composable
fun CategoryVO.getTextColor() = when(this.code) {
    "MA" -> Color.White
    "PC" -> Color.White
    "BG" -> Color.Black
    "ME" -> Color.Black
    "CS" -> Color.Black
    "VG" -> Color.Black
    "MU" -> Color.Black
    "MS" -> Color.Black
    "AL" -> Color.Black
    "GF" -> Color.White
    "HI" -> Color.Black
    "GE" -> Color.Black
    "FE" -> Color.Black
    "IB" -> Color.White
    "AT" -> Color.White
    "AM" -> Color.White
    "SH" -> Color.White
    "RN" -> Color.White
    "RM" -> Color.Black
    "BD" -> Color.Black
    "PL" -> Color.White
    "SM" -> Color.Black
    "OT" -> Color.White
    else -> Color.Black
}