package com.hotmart.baseapi.usecase.person.request

import com.hotmart.baseapi.domain.entity.Person
import java.util.*

data class UpdatePersonRequest(
    val id: UUID,
    val name: String
)