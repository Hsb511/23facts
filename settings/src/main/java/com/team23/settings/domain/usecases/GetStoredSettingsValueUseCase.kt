package com.team23.settings.domain.usecases

import com.team23.settings.domain.models.RandomnessType
import com.team23.settings.domain.repositories.SettingRepository
import javax.inject.Inject

class GetStoredSettingsValueUseCase @Inject constructor(
    private val settingsRepository: SettingRepository
) {
    suspend operator fun invoke(): List<Int> {
        val allStoredValues = settingsRepository.getAllStoredValues()
        val themeSettingValue = allStoredValues.firstOrNull { it.id == 0L }?.value?.toIntOrNull() ?: 1
        val colorSettingValue = allStoredValues.firstOrNull { it.id == 1L }?.value?.toIntOrNull() ?: 0
        val randomnessSettingValue = allStoredValues.firstOrNull { it.id == 2L }?.value?.let {
            RandomnessType.values().map { randomType -> randomType.name }.indexOf(it)
        } ?: 0

        return listOf(
            themeSettingValue, colorSettingValue, randomnessSettingValue
        )
    }

}