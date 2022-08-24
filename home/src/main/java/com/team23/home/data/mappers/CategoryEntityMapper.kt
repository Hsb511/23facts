package com.team23.home.data.mappers

import com.team23.home.domain.models.CategoryModel
import com.team23.room.data.entities.CategoryEntity

fun CategoryEntity.toModel(language: String) = CategoryModel(
    title = if (language == "fr") { this.name_fr } else this.name_en
)