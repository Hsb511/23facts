package com.team23.search.data.mappers

import com.team23.room.data.entities.FactEntity
import com.team23.search.domain.models.FactPreview

fun List<FactEntity>.toModels() = this.map { it.toModel() }

fun FactEntity.toModel() = FactPreview(
    id = this.id_fonc,
    category = this.code,
    imageUrl = this.image,
    title = this.title,
    text = this.content
)