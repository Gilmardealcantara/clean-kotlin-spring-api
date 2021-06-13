package com.hotmart.baseapi.usecase.person.response

import com.hotmart.baseapi.domain.entity.Person
import com.hotmart.baseapi.domain.entity.ResourceAction
import com.hotmart.baseapi.usecase.base.BaseEntityResponse
import java.util.*

class PersonResponse(
    id: UUID,
    actions: List<ResourceAction>,
    val name: String,
) : BaseEntityResponse(id, actions) {
    constructor(person: Person) : this(person.id, person.actions, person.name)
}