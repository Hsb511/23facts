package com.team23.search.domain.usecases

import androidx.compose.ui.text.intl.Locale
import com.team23.search.domain.models.FactPreview
import com.team23.search.domain.repositories.FactRepository
import javax.inject.Inject

class SearchFactsUseCase @Inject constructor(
    private val factRepository: FactRepository
) {
    companion object {
        private const val MINIMUM_CHARACTER_FOR_SEARCH = 1
        private const val LINE_AMOUNT = 3
        private const val MAXIMUM_TEXT_LENGTH = 35 * LINE_AMOUNT
    }

    suspend operator fun invoke(searchText: String): List<FactPreview> =
        if (searchText.length <= MINIMUM_CHARACTER_FOR_SEARCH) {
            emptyList()
        } else {
            // TODO REORDER THE LIST BY : FIRST IN TITLE, FIRST IN CONTENT, FIRST IN LINKS
            val factPreviews = factRepository.searchFacts(searchText, Locale.current.language)
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