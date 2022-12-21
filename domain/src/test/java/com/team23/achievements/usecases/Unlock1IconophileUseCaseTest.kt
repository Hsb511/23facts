package com.team23.achievements.usecases

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class Unlock1IconophileUseCaseTest {
    companion object {
        private const val ACHIEVEMENT_1_NAME = "ACHIEVEMENT_1_NAME"
    }

    private val unlockAchievementUseCase = mockk<UnlockAchievementUseCase> {
        coEvery { this@mockk.invoke(any()) } returns Unit
    }
    private val unlock1IconophileUseCase = Unlock1IconophileUseCase(unlockAchievementUseCase)

    @Test
    fun `Given app icon 0 time clicked, When unlock1IconophileUseCase is invoked, Then returns null`() =
        runBlocking {
            // Given
            val appIconClickAmount = 0

            // When
            val result = unlock1IconophileUseCase.invoke(appIconClickAmount, ACHIEVEMENT_1_NAME)

            // Then
            assertEquals(null, result)
            coVerify(exactly = 0) { unlockAchievementUseCase(any()) }
        }

    @Test
    fun `Given app icon 1 time clicked, When unlock1IconophileUseCase is invoked, Then returns null`() =
        runBlocking {
            // Given
            val appIconClickAmount = 1

            // When
            val result = unlock1IconophileUseCase.invoke(appIconClickAmount, ACHIEVEMENT_1_NAME)

            // Then
            assertEquals(null, result)
            coVerify(exactly = 0) { unlockAchievementUseCase(any()) }
        }

    @Test
    fun `Given app icon 22 time clicked, When unlock1IconophileUseCase is invoked, Then returns null`() =
        runBlocking {
            // Given
            val appIconClickAmount = 22

            // When
            val result = unlock1IconophileUseCase.invoke(appIconClickAmount, ACHIEVEMENT_1_NAME)

            // Then
            assertEquals(null, result)
            coVerify(exactly = 0) { unlockAchievementUseCase(any()) }
        }

    @Test
    fun `Given app icon 23 times clicked, When unlock1IconophileUseCase is invoked, Then returns null`() =
        runBlocking {
            // Given
            val appIconClickAmount = 23

            // When
            val result = unlock1IconophileUseCase.invoke(appIconClickAmount, ACHIEVEMENT_1_NAME)

            // Then
            assertEquals(ACHIEVEMENT_1_NAME, result!!.name)
            assertEquals(true, result.isFound)
            coVerify(exactly = 1) { unlockAchievementUseCase(ACHIEVEMENT_1_NAME) }
        }
}