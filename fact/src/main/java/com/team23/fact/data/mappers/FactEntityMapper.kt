package com.team23.fact.data.mappers

import com.team23.fact.domain.models.FactModel
import com.team23.room.data.entities.FactEntity

fun FactEntity.toModel() = FactModel(
    id = this.id_fonc.toString(),
    title = this.title,
    category = this.code,
    image = this.image,
    description = this.content,
    sources = this.links
)