package com.team23.home.data.mappers

import com.team23.home.domain.models.CategoryModel
import com.team23.room.data.entities.CategoryEntity

fun CategoryEntity.toModel() = CategoryModel(
    titleEn = this.name_en,
    titleFr = this.name_fr
)