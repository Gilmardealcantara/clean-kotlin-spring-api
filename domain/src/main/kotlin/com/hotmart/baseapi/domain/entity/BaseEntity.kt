package com.hotmart.baseapi.domain.entity

import java.util.*

abstract class BaseEntity(
    val id: UUID
) {
    abstract val actions: List<ResourceAction> // first is the self
}