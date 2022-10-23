package com.team23.fact.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.team23.achievements.presentation.viewmodels.AchievementVM
import com.team23.fact.domain.usecases.GetAndReadFactUseCase
import com.team23.fact.domain.usecases.GetCategoryNameUseCase
import com.team23.fact.domain.usecases.GetCategoryShortNameUseCase
import com.team23.fact.domain.usecases.GetOpenGraphMetaDataFromUrlUseCase
import com.team23.fact.presentation.viewobjects.CategoryVO
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
    @Assisted private val achievementVM: AchievementVM,
    private val getAndReadFactUseCase: GetAndReadFactUseCase,
    private val getCategoryNameUseCase: GetCategoryNameUseCase,
    private val getCategoryShortNameUseCase: GetCategoryShortNameUseCase,
    private val getOpenGraphMetaDataFromUrlUseCase: GetOpenGraphMetaDataFromUrlUseCase,
) : ViewModel() {
    val factDetail: MutableState<FactDetailVO?> = mutableStateOf(null)
    val factSources: SnapshotStateList<FactDetailLinkVO?> = mutableStateListOf(null)

    fun loadFactDetail(newFactId: String?) {
        if (factId != newFactId) {
            resetData()
            viewModelScope.launch(Dispatchers.IO) {
                val factModel = getAndReadFactUseCase.execute(newFactId)
                achievementVM.onFactLoaded()
                val category = getCategoryNameUseCase(factModel?.category)
                val categoryShort = getCategoryShortNameUseCase(factModel?.category)
                withContext(Dispatchers.Main) {
                    factDetail.value = FactDetailVO(
                        id = "#${factModel?.id}",
                        title = factModel?.title ?: "",
                        category = CategoryVO(
                            code = factModel?.category,
                            name = category,
                            shortName = categoryShort,
                        ),
                        imageUrl = factModel?.image,
                        description = factModel?.description?.replace("\\n", "\n") ?: "",
                    )
                    factId = factModel?.id
                }
                val sources = loadSources(factModel?.sources)
                withContext(Dispatchers.Main) {
                    factSources.clear()
                    factSources.addAll(sources)
                }
            }
        }
    }

    private fun resetData() {
        factId = null
        factDetail.value = null
        factSources.clear()
        factSources.add(null)
    }

    private suspend fun loadSources(rawSources: String?): List<FactDetailLinkVO> =
        rawSources
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
                            og.title ?: factDetail.value?.title ?: ""
                        }.trim().take(31),
                        domainName = when {
                            og.siteName != null -> og.siteName!!
                            og.title != null && og.title!!.contains(" — Wikipédia") -> "Wikipédia"
                            else -> it.split("://")[1].split("/")[0]
                        }.trim().take(31),
                        language = when (og.language) {
                            "fr" -> "\uD83C\uDDEB\uD83C\uDDF7"
                            "de" -> "\uD83C\uDDE9\uD83C\uDDEA"
                            "es" -> "\uD83C\uDDEA\uD83C\uDDF8"
                            else -> "\uD83C\uDDEC\uD83C\uDDE7"
                        }
                    )
                }
            } ?: emptyList()

    @AssistedFactory
    interface Factory {
        fun create(factId: String?, achievementVM: AchievementVM): FactDetailVM
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            factId: String?,
            achievementVM: AchievementVM,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return assistedFactory.create(factId, achievementVM) as T
            }
        }
    }
}