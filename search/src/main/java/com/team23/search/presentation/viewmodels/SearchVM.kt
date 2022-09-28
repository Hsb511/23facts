package com.team23.search.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import com.team23.search.presentation.viewobjects.FactPreviewVO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchVM @Inject constructor() : ViewModel() {
    val searchText: MutableState<TextFieldValue> = mutableStateOf(TextFieldValue(""))
    val facts = mutableStateListOf<FactPreviewVO>()

}