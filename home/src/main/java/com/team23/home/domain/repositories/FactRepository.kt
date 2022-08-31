package com.team23.home.domain.repositories

import com.team23.home.domain.models.FactPreviewModel

interface FactRepository {
    suspend fun getFactsByCategory(codeCategory: String, language: String): List<FactPreviewModel>
}