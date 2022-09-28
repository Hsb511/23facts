package com.team23.search.domain.repositories

import com.team23.search.domain.models.FactPreview

interface FactRepository {
    suspend fun searchFacts(searchText: String, language: String): List<FactPreview>
}