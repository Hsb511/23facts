package com.team23.settings.domain.usecases

import com.team23.settings.domain.models.RandomnessType
import com.team23.settings.domain.repositories.SettingRepository
import javax.inject.Inject

class GetStoredSettingsValueUseCase @Inject constructor(
    private val settingsRepository: SettingRepository
) {
    suspend operator fun invoke(): List<Int> =
        settingsRepository.getAllStoredValues().map { setting ->
            when (setting.id) {
                0L -> 1
                1L -> 0
                else -> RandomnessType.values().map { it.name }.indexOf(setting.value)
            }
        }
}