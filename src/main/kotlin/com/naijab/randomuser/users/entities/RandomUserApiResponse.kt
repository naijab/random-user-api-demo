package com.naijab.randomuser.users.entities

data class RandomUserApiResponse(
    val results: List<Result>,
    val info: Info,
)

data class Info(
    val seed: String,
    val results: Long,
    val page: Long,
    val version: String,
)

data class Result(
    val gender: String? = null,
    val name: Name? = null,
    val location: Location? = null,
    val email: String? = null,
    val login: Login? = null,
    val dob: Dob? = null,
    val registered: Dob? = null,
    val phone: String? = null,
    val cell: String? = null,
    val id: ID? = null,
    val picture: Picture? = null,
    val nat: String? = null,
)

data class Dob(
    val date: String? = null,
    val age: Long? = null,
)

data class ID(
    val name: String? = null,
    val value: String? = null,
)

data class Location(
    val street: Street? = null,
    val city: String? = null,
    val state: String? = null,
    val country: String? = null,
    val postcode: String? = null,
    val coordinates: Coordinates? = null,
    val timezone: Timezone? = null,
)

data class Coordinates(
    val latitude: String? = null,
    val longitude: String? = null,
)

data class Street(
    val number: Long? = null,
    val name: String? = null,
)

data class Timezone(
    val offset: String? = null,
    val description: String? = null,
)

data class Login(
    val uuid: String? = null,
    val username: String? = null,
    val password: String? = null,
    val salt: String? = null,
    val md5: String? = null,
    val sha1: String? = null,
    val sha256: String? = null,
)

data class Name(
    val title: String? = null,
    val first: String? = null,
    val last: String? = null,
)

data class Picture(
    val large: String? = null,
    val medium: String? = null,
    val thumbnail: String? = null,
)
