package com.team23.fact.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.team23.fact.domain.usecases.GetCategoryUseCase
import com.team23.fact.domain.usecases.GetFactUseCase
import com.team23.fact.domain.usecases.GetOpenGraphMetaDataFromUrlUseCase
import com.team23.fact.presentation.viewobjects.FactDetailLinkVO
import com.team23.fact.presentation.viewobjects.FactDetailVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FactDetailVM @Inject constructor(
    private val getFactUseCase: GetFactUseCase,
    private val getCategoryUseCase: GetCategoryUseCase,
    private val getOpenGraphMetaDataFromUrlUseCase: GetOpenGraphMetaDataFromUrlUseCase
) : ViewModel() {
    val factDetail: MutableState<FactDetailVO> = mutableStateOf(FactDetailVO())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val factModel = getFactUseCase.execute(
                // TODO CHANGE THAT
                listOf("69", "92", "115", "138").random()
            )
            val category = getCategoryUseCase.execute(factModel?.category)
            val sources = factModel?.sources
                ?.split(";")
                ?.filter { it.isNotBlank() }
                ?.map {
                    getOpenGraphMetaDataFromUrlUseCase.execute(it).let { og ->
                        FactDetailLinkVO(
                            url = og.url!!,
                            image = og.image,
                            title = og.title ?: factDetail.value.title,
                            domainName = og.siteName ?: og.url!!.split("://")[1].split("/")[0]
                        )
                    }
                } ?: emptyList()
            withContext(Dispatchers.Main) {
                factDetail.value = FactDetailVO(
                    id = "#${factModel?.id}",
                    title = factModel?.title ?: "",
                    category = category,
                    imageUrl = factModel?.image,
                    description = factModel?.description ?: "",
                    sources = sources
                )
            }
        }
    }
}