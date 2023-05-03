package com.naijab.randomuser.users.datasource.remote

import com.naijab.randomuser.users.datasource.RandomUserDataSource
import com.naijab.randomuser.users.entities.RandomUserApiResponse
import com.naijab.randomuser.users.entities.RandomUserResponse
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class RandomUserRemoteDataSource() : RandomUserDataSource {

    override fun get(seed: String): List<RandomUserResponse> {
        val restTemplate = RestTemplate()
        val url = "https://randomuser.me/api/?seed=$seed"
        val apiResponse = restTemplate.getForObject(url, RandomUserApiResponse::class.java)

        val resuls: List<RandomUserResponse> = apiResponse?.results?.map {
            RandomUserResponse(
                firstName = it.name?.first ?: "",
                lastName = it.name?.last ?: "",
                gender = it.gender ?: "",
                email = it.email ?: "",
            )
        }.orEmpty()

        return resuls
    }
}
