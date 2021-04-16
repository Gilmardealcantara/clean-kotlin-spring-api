package com.hotmart.baseapi.usecase.person.request

import com.hotmart.baseapi.domain.entity.Person
import java.util.*

data class CreatePersonRequest(
    val name: String
) {
    fun toModel(): Person {
        val uuid = UUID.randomUUID()
        return Person(uuid, name)
    }
}