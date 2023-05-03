package com.naijab.randomuser.users.usecase
import com.naijab.randomuser.users.entities.RandomUserResponse
import com.naijab.randomuser.users.repositories.RandomUserRepository
import org.springframework.stereotype.Service

interface GetRandomUserWithSeedUsecase {
    fun excute(seed: String): List<RandomUserResponse>
}

@Service
class GetRandomUserWithSeedUsecaseImpl(val repository: RandomUserRepository) : GetRandomUserWithSeedUsecase {
    override fun excute(seed: String): List<RandomUserResponse> {
        return repository.get(seed)
    }
}
