package com.naijab.randomuser.users.repositories

import com.naijab.randomuser.users.datasource.remote.RandomUserRemoteDataSource
import com.naijab.randomuser.users.entities.RandomUserResponse
import org.springframework.stereotype.Repository

interface RandomUserRepository {
    fun get(seed: String): List<RandomUserResponse>
}

@Repository
class RandomUserRepositoryImpl(val remoteDataSource: RandomUserRemoteDataSource) : RandomUserRepository {
    override fun get(seed: String): List<RandomUserResponse> {
        return remoteDataSource.get(seed)
    }
}
