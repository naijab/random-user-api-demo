package com.naijab.randomuser.users.datasource
import com.naijab.randomuser.users.entities.RandomUserResponse

interface RandomUserDataSource {
    fun get(seed: String): List<RandomUserResponse>
}
