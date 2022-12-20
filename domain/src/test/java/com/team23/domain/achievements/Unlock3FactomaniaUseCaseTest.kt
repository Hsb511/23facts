package com.team23.domain.achievements

import com.team23.achievements.repositories.FactRepository
import com.team23.achievements.usecases.Unlock3FactomaniaUseCase
import com.team23.achievements.usecases.UnlockAchievementUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class Unlock3FactomaniaUseCaseTest {
    companion object {
        private const val ACHIEVEMENT_3_NAME = "ACHIEVEMENT_3_NAME"
    }

    private val unlockAchievementUseCase = mockk<UnlockAchievementUseCase> {
        coEvery { this@mockk.invoke(any()) } returns Unit
    }
    private val factRepository = mockk<FactRepository>()
    private val unlock3FactomaniaUseCase = Unlock3FactomaniaUseCase(unlockAchievementUseCase, factRepository)

    @Test
    fun `Given 0 facts read, When unlock3FactomaniaUseCase is invoked, Then returns null`() =
        runBlocking {
            // Given
            coEvery { factRepository.countReadFacts() } returns 0

            // When
            val result = unlock3FactomaniaUseCase.invoke(ACHIEVEMENT_3_NAME)

            // Then
            assertEquals(null, result)
            coVerify(exactly = 0) { unlockAchievementUseCase(any()) }
        }

    @Test
    fun `Given 44 facts read, When unlock3FactomaniaUseCase is invoked, Then returns null`() =
        runBlocking {
            // Given
            coEvery { factRepository.countReadFacts() } returns 44

            // When
            val result = unlock3FactomaniaUseCase.invoke(ACHIEVEMENT_3_NAME)

            // Then
            assertEquals(null, result)
            coVerify(exactly = 0) { unlockAchievementUseCase(any()) }
        }

    @Test
    fun `Given 46 facts read, When unlock3FactomaniaUseCase is invoked, Then returns achievement`() =
        runBlocking {
            // Given
            coEvery { factRepository.countReadFacts() } returns 46

            // When
            val result = unlock3FactomaniaUseCase.invoke(ACHIEVEMENT_3_NAME)

            // Then
            assertEquals(ACHIEVEMENT_3_NAME, result!!.name)
            assertTrue(result.isFound)
            coVerify(exactly = 1) { unlockAchievementUseCase(ACHIEVEMENT_3_NAME) }
        }

    @Test
    fun `Given factRepository throws an error, When unlock3FactomaniaUseCase is invoked, Then returns null`() =
        runBlocking {
            // Given
            coEvery { factRepository.countReadFacts() } throws NullPointerException()

            // When
            val result = unlock3FactomaniaUseCase.invoke(ACHIEVEMENT_3_NAME)

            // Then
            assertEquals(null, result)
            coVerify(exactly = 0) { unlockAchievementUseCase(any()) }
        }
}