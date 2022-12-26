package com.team23.search.usecases

import com.team23.search.models.FactPreview
import com.team23.search.repositories.FactSearchRepository
import javax.inject.Inject

class SearchFactsUseCase @Inject constructor(
    private val factSearchRepository: FactSearchRepository
) {
    companion object {
        private const val MINIMUM_CHARACTER_FOR_SEARCH = 1
        private const val LINE_AMOUNT = 3
        private const val MAXIMUM_TEXT_LENGTH = 35 * LINE_AMOUNT
    }

    suspend operator fun invoke(searchText: String, currentLanguage: String): List<FactPreview> =
        if (searchText.length <= MINIMUM_CHARACTER_FOR_SEARCH) {
            emptyList()
        } else {
            val factPreviews = factSearchRepository.searchFacts(searchText, currentLanguage)
            factPreviews.forEach { factPreview ->
                if (factPreview.text.contains(searchText)) {
                    val splitText = factPreview.text.split(searchText).toMutableList()
                    val firstElement = splitText[0]
                    splitText.removeAt(0)
                    val secondHalf =
                        splitText.joinToString(separator = searchText, prefix = "", postfix = "")
                    val firstHalf = when {
                        firstElement.length <= MAXIMUM_TEXT_LENGTH / 2 -> firstElement
                        secondHalf.length <= MAXIMUM_TEXT_LENGTH / 2 -> {
                            firstElement.substring(firstElement.length - MAXIMUM_TEXT_LENGTH - searchText.length - secondHalf.length)
                        }
                        else -> firstElement.substring(firstElement.length - MAXIMUM_TEXT_LENGTH / 2)
                    }
                    val newText = firstHalf + searchText + secondHalf
                    factPreview.text = newText
                }
                factPreview.text = factPreview.text.replace("\\n", " ")
            }
            factPreviews
        }
}