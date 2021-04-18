package com.hotmart.baseapi.domain.service

import com.hotmart.baseapi.domain.entity.Person
import java.util.*

interface IPersonRepository {
    fun save(person: Person)
    fun update(person: Person)
    fun findById(id: UUID): Optional<Person>
    fun findAll(): Collection<Person>
}