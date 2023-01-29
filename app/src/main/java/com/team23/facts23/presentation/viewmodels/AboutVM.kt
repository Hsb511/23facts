package com.team23.facts23.presentation.viewmodels

import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.team23.facts23.domain.usecases.GetBuildVersionUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class AboutVM @AssistedInject constructor(
    @Assisted val launchEmailIntent: (String) -> Unit,
    @Assisted val onPrivacyPolicyClicked: (Uri) -> Unit,
    getBuildVersionUseCase: GetBuildVersionUseCase
) : ViewModel() {
    val buildVersion: MutableState<String> = mutableStateOf(getBuildVersionUseCase())

    @AssistedFactory
    interface Factory {
        fun create(
            launchEmailIntent: (String) -> Unit,
            onPrivacyPolicyClicked: (Uri) -> Unit,
        ): AboutVM
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun provideFactory(
            assistedFactory: Factory,
            launchEmailIntent: (String) -> Unit,
            onPrivacyPolicyClicked: (Uri) -> Unit,
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return assistedFactory.create(launchEmailIntent, onPrivacyPolicyClicked) as T
            }
        }
    }
}