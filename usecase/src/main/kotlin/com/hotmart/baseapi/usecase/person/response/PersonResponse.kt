package com.hotmart.baseapi.usecase.person.response

import com.hotmart.baseapi.domain.entity.Person
import java.util.*

data class PersonResponse(
    val id: UUID,
    val name: String
) {
    constructor(person: Person) : this(person.id, person.name)
}