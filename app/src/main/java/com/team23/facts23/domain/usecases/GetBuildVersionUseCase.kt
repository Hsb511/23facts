package com.team23.facts23.domain.usecases

import com.team23.facts23.BuildConfig
import javax.inject.Inject

class GetBuildVersionUseCase @Inject constructor() {
    operator fun invoke(): String {
        return BuildConfig.VERSION_NAME
    }
}