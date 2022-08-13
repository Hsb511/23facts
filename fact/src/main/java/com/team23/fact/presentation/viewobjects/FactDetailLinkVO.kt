package com.team23.fact.presentation.viewobjects

import androidx.compose.ui.graphics.ImageBitmap

data class FactDetailLinkVO(
    val url: String,
    val imageBitmap: ImageBitmap? = null,
    val title: String? = null,
    val domainName: String? = null
)
