package com.team23.search.repositories

import com.team23.search.models.FactPreview

interface FactSearchRepository {
    suspend fun searchFacts(searchText: String, language: String): List<FactPreview>
}