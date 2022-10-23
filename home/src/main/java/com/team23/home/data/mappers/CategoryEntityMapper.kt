package com.team23.home.data.mappers

import com.team23.home.domain.models.CategoryModel
import com.team23.room.data.entities.CategoryEntity

fun CategoryEntity.toModel() = CategoryModel(
    code = this.code,
    titleEn = this.name_en,
    titleFr = this.name_fr,
    shortTitleEn = this.short_name_en,
    shortTitleFr = this.short_name_fr,
)