package com.team23.search.domain.models

data class FactPreview(
    val id: Long,
    val category: String,
    val imageUrl: String,
    val title: String,
    var text: String,
)
