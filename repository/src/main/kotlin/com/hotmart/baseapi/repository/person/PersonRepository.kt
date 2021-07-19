package com.hotmart.baseapi.repository.person

import com.hotmart.baseapi.domain.entity.Person
import com.hotmart.baseapi.domain.service.IPersonRepository
import com.hotmart.baseapi.data.PersonDataMapper
import java.util.*

//@Repository
open class PersonRepository(
    private val repository: PersonSpringDataRepository
) : IPersonRepository {
    override fun save(person: Person) {
        repository.save(PersonDataMapper(person))
    }

    override fun update(person: Person) {
        repository.save(PersonDataMapper(person))
    }

    override fun findById(id: UUID): Optional<Person> {
        return repository.findById(id).map { it.toModel() }
    }

    override fun findAll(): Collection<Person> {
        return repository.findAll().map { it.toModel() }
    }
}
