package com.naijab.randomuser.users.usecase

import com.naijab.randomuser.users.entities.RandomUserResponse
import com.naijab.randomuser.users.repositories.RandomUserRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test

internal class GetRandomUserWithSeedUsecaseTest {

    private val repository: RandomUserRepository = mockk(relaxed = true)
    private val getRandomUserWithSeedUsecase = GetRandomUserWithSeedUsecaseImpl(repository)

    @Test
    fun `Get random user should return list of user`() {
        val seed = "seed"
        val expectResult = listOf(
            RandomUserResponse(
                firstName = "Bello",
                lastName = "Kll",
                gender = "male",
                email = "test@mail.com",
            ),
        )

        every { repository.get(seed) } returns expectResult

        val actualResult = getRandomUserWithSeedUsecase.excute(seed)

        assertIterableEquals(expectResult, actualResult)
    }
}
