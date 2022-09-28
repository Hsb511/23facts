package com.team23.search.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team23.search.domain.usecases.SearchFactsUseCase
import com.team23.search.presentation.mappers.toVO
import com.team23.search.presentation.viewobjects.FactPreviewVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchVM @Inject constructor(
    private val searchFactsUseCase: SearchFactsUseCase
) : ViewModel() {
    val searchText: MutableState<String> = mutableStateOf("")
    val facts = mutableStateListOf<FactPreviewVO>()

    fun onTextChanged(newText: String) {
        if (newText != searchText.value) {
            facts.clear()
            viewModelScope.launch(Dispatchers.IO) {
                searchFactsUseCase(newText).also { factPreviews ->
                    withContext(Dispatchers.Main) {
                        factPreviews.forEach {
                            facts.add(it.toVO())
                        }
                    }
                }
            }
        }
    }
}