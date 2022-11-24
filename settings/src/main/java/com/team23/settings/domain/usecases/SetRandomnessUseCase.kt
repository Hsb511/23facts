package com.team23.settings.domain.usecases

import com.team23.settings.domain.models.RandomnessType
import com.team23.settings.domain.repositories.SettingRepository
import javax.inject.Inject

class SetRandomnessUseCase @Inject constructor(
    private val settingsRepository: SettingRepository
) {
    suspend operator fun invoke(randomness: RandomnessType) {
        settingsRepository.updateRandomSetting(randomness.name)
    }
}