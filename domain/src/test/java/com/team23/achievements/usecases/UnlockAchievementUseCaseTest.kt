package com.team23.achievements.usecases

import com.team23.achievements.repositories.AchievementRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class UnlockAchievementUseCaseTest {
    companion object {
        private const val ACHIEVEMENT_1_NAME = "ACHIEVEMENT_1_NAME"
    }

    private val achievementRepository = mockk<AchievementRepository>()
    private val unlockAchievementUseCase = UnlockAchievementUseCase(achievementRepository)

    @Test
    fun `Given achievement 1 name, When unlockAchievementUseCase is invoked, Then store data`() = runBlocking {
        // Given
        coEvery { achievementRepository.unlockAchievement(ACHIEVEMENT_1_NAME, any()) } returns Unit

        // When
        unlockAchievementUseCase.invoke(ACHIEVEMENT_1_NAME)

        // Then
        coVerify(exactly = 1) { achievementRepository.unlockAchievement(ACHIEVEMENT_1_NAME, any()) }
    }

    @Test(expected = NullPointerException::class)
    fun `Given achievementRepository throw exception, When unlockAchievementUseCase is invoked, Then throw exception`() = runBlocking {
        // Given
        coEvery { achievementRepository.unlockAchievement(any(), any()) } throws NullPointerException()

        // When
        unlockAchievementUseCase.invoke(ACHIEVEMENT_1_NAME)

        // Then
        coVerify(exactly = 1) { achievementRepository.unlockAchievement(ACHIEVEMENT_1_NAME, any()) }
    }
}