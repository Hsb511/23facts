package com.team23.fact.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.team23.fact.domain.usecases.GetCategoryUseCase
import com.team23.fact.domain.usecases.GetFactUseCase
import com.team23.fact.domain.usecases.GetOpenGraphMetaDataFromUrlUseCase
import com.team23.fact.presentation.viewobjects.FactDetailLinkVO
import com.team23.fact.presentation.viewobjects.FactDetailVO
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FactDetailVM @AssistedInject constructor(
    @Assisted var factId: String?,
    private val getFactUseCase: GetFactUseCase,
    private val getCategoryUseCase: GetCategoryUseCase,
    private val getOpenGraphMetaDataFromUrlUseCase: GetOpenGraphMetaDataFromUrlUseCase
) : ViewModel() {
    val factDetail: MutableState<FactDetailVO?> = mutableStateOf(null)

    init {
        loadFactDetail(factId)
    }

    fun loadFactDetail(newFactId: String?) {
        factDetail.value = null
        factId = newFactId
        viewModelScope.launch(Dispatchers.IO) {
            val factModel = getFactUseCase.execute(factId)
            val category = getCategoryUseCase.execute(factModel?.category)
            val sources = factModel?.sources
                ?.split(";")
                ?.filter { it.isNotBlank() }
                ?.map {
                    getOpenGraphMetaDataFromUrlUseCase.execute(it).let { og ->
                        FactDetailLinkVO(
                            url = it,
                            image = og.image?.ifBlank { null } ?: og.favicon,
                            title = if (og.title != null && og.title!!.contains(" — Wikipédia")) {
                                og.title!!.split(" — Wikipédia")[0]
                            } else {
                                og.title ?: "" //factDetail.value.title
                            }.trim().take(31),
                            domainName = when {
                                og.siteName != null -> og.siteName!!
                                og.title != null && og.title!!.contains(" — Wikipédia") -> "Wikipédia"
                                else -> it.split("://")[1].split("/")[0]
                            }.trim().take(31)
                        )
                    }
                } ?: emptyList()
            withContext(Dispatchers.Main) {
                factDetail.value = FactDetailVO(
                    id = "#${factModel?.id}",
                    title = factModel?.title ?: "",
                    category = category,
                    imageUrl = factModel?.image,
                    description = factModel?.description?.replace("\\n", "\n") ?: "",
                    sources = sources
                )
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(factId: String?): FactDetailVM
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            factId: String?
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return assistedFactory.create(factId) as T
            }
        }
    }
}