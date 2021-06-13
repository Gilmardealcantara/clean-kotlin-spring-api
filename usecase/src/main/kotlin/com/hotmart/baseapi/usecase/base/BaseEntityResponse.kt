package com.hotmart.baseapi.usecase.base

import java.util.*

abstract class BaseEntityResponse(
    val id: UUID,
    var actions: List<Any>
)