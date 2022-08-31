package com.team23.home.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team23.home.domain.usecases.GetAllCategoriesUseCase
import com.team23.home.domain.usecases.GetAllFactsByCategoryUseCase
import com.team23.home.presentation.viewobjects.CategoryVO
import com.team23.home.presentation.viewobjects.FactVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val getAllFactsByCategoryUseCase: GetAllFactsByCategoryUseCase
) : ViewModel() {
    val categories = mutableStateListOf<CategoryVO>()
    val selectedCategory: MutableState<CategoryVO?> = mutableStateOf(null)
    val facts = mutableStateListOf<FactVO>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getAllCategoriesUseCase.execute().also {
                withContext(Dispatchers.Main) {
                    categories.addAll(it)
                }
            }
        }
    }

    fun onCategoryClicked(categoryVO: CategoryVO) {
        selectedCategory.value = categoryVO
        viewModelScope.launch(Dispatchers.IO) {
            facts.addAll(
                getAllFactsByCategoryUseCase.execute(categoryVO.code).map {
                    FactVO(
                        picture = it.picture,
                        title = it.title,
                        id = it.id.toString()
                    )
                }
            )
        }
    }

    fun onReturnHome() {
        selectedCategory.value = null
        facts.clear()
    }
}