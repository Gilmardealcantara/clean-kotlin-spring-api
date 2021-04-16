package com.hotmart.baseapi.domain.entity

import java.util.*

class Person(
    val id: UUID,
    name: String,
) {
    var name: String = name
        private set

    fun changeName(name: String) {
        this.name = name
    }
}