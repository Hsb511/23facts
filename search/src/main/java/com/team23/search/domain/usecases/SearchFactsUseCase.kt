package com.team23.search.domain.usecases

import com.team23.search.domain.models.FactPreview
import com.team23.search.domain.repositories.FactRepository
import javax.inject.Inject

class SearchFactsUseCase @Inject constructor(
    private val factRepository: FactRepository
) {
    suspend fun invoke(searchText: String): List<FactPreview> {
        return if (searchText.length < 3) {
            emptyList()
        } else {
            // TODO LIMIT TEXT SIZE
            // TODO REORDER THE LIST BY : FIRST IN TITLE, FIRST IN CONTENT, FIRST IN LINKS
            factRepository.searchFacts(searchText)
        }
    }
}