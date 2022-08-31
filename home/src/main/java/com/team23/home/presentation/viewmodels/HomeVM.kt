package com.team23.home.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team23.home.domain.usecases.GetAllCategoriesUseCase
import com.team23.home.presentation.viewobjects.CategoryVO
import com.team23.home.presentation.viewobjects.FactVO
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
        facts.addAll(
            listOf(
                FactVO(
                    "https://images.unsplash.com/photo-1602631985686-1bb0e6a8696e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
                    "Le Paradoxe des Anniversaires", "46"
                ),
                FactVO(
                    "https://miro.medium.com/max/1400/1*ahy12g2hFP21x7YolyQ_Ug.jpeg",
                    "Les problèmes de Hilbert",
                    "69"
                ),
                FactVO(
                    "https://pbs.twimg.com/profile_images/1586710859/Leonhard_Euler_400x400.jpg",
                    "The first problem of the Project Euler",
                    "92"
                )
            )
        )
    }

    fun onCategoryClicked(categoryVO: CategoryVO) {
        selectedCategory.value = categoryVO
    }

    fun onReturnHome() {
        selectedCategory.value = null
    }
}