package com.hotmart.baseapi.domain.entity

import java.util.*

class Person(id: UUID, name: String) : BaseEntity(id) {
    override val actions: List<ResourceAction> = listOf(
        ResourceAction.LIST_BY_ID,
        ResourceAction.CREATE,
        ResourceAction.UPDATE,
        ResourceAction.DELETE
    )

    var name: String = name
        private set

    fun changeName(name: String) {
        this.name = name
    }
}