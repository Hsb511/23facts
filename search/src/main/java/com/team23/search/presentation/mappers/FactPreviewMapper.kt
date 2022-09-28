package com.team23.search.presentation.mappers

import androidx.compose.ui.text.AnnotatedString
import com.team23.search.domain.models.FactPreview
import com.team23.search.presentation.viewobjects.FactPreviewVO

fun FactPreview.toVO() = FactPreviewVO(
    imageUrl = this.imageUrl,
    // TODO MAKE SEARCH TEXT IN BOLD
    title = AnnotatedString(this.title),
    text = AnnotatedString(this.text),
)