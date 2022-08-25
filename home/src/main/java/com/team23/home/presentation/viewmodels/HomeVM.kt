package com.team23.home.presentation.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team23.home.domain.usecases.GetAllCategoriesUseCase
import com.team23.home.presentation.viewobjects.CategoryVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
) : ViewModel() {
    val categories = mutableStateListOf<CategoryVO>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllCategoriesUseCase.execute().also {
                withContext(Dispatchers.Main) {
                    categories.addAll(it)
                }
            }
        }
    }
}