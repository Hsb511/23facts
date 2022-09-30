package com.team23.search.presentation.mappers

import com.team23.search.domain.models.FactPreview
import com.team23.search.presentation.viewobjects.FactPreviewVO

fun FactPreview.toVO() = FactPreviewVO(
    id = this.id,
    category = this.category,
    imageUrl = this.imageUrl,
    title = this.title,
    text = this.text,
)