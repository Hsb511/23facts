package com.team23.settings.presentation.viewobjects

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState

data class SettingsSingleChoiceVO(
    @StringRes
    val titleId: Int,
    @StringRes
    val values: List<Int>,
    val onValueChanged: (Int) -> Unit,
    val selectedValue: MutableState<Int>,
    val disabled: Boolean = false,
    val displayed: Boolean = true,
)
