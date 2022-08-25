package com.team23.fact.presentation.viewobjects

import androidx.compose.ui.graphics.ImageBitmap

data class FactDetailVO(
    val id: String = "",
    val title: String = "",
    val category: String = "",
    val imageUrl: String? = null,
    val imageBitmap: ImageBitmap? = null,
    val description: String = "",
    val sources: List<FactDetailLinkVO> = emptyList()
)
