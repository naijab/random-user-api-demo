package com.naijab.randomuser.users.repositories

import com.naijab.randomuser.users.entities.RandomUserApiResponse
import com.naijab.randomuser.users.entities.RandomUserResponse
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

interface RandomUserRepository {
    fun get(seed: String): List<RandomUserResponse>
}

@Repository
class RandomUserRepositoryImpl : RandomUserRepository {
    override fun get(seed: String): List<RandomUserResponse> {
        val restTemplate = RestTemplate()
        val url = "https://randomuser.me/api/?seed=$seed"
        val apiResponse = restTemplate.getForObject(url, RandomUserApiResponse::class.java)

        val resuls: List<RandomUserResponse> = apiResponse?.results?.map {
            RandomUserResponse(
                firstName = it.name.first,
                lastName = it.name.last,
                gender = it.gender,
                email = it.email,
            )
        }.orEmpty()

        return resuls
    }
}
