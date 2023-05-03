package com.naijab.randomuser.users.controller

import com.naijab.randomuser.users.entities.RandomUserResponse
import com.naijab.randomuser.users.usecase.GetRandomUserWithSeedUsecase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class RandomUserController(val getRandomUserWithSeedUsecase: GetRandomUserWithSeedUsecase) {

    @GetMapping("/users/{seed}")
    fun getRandomUserWithSeed(@PathVariable seed: String): Mono<List<RandomUserResponse>> {
        return Mono.just(getRandomUserWithSeedUsecase.excute(seed))
    }
}
