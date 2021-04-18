package com.hotmart.repository.person

import com.hotmart.baseapi.domain.entity.Person
import com.hotmart.baseapi.domain.service.IPersonRepository
import java.lang.IllegalArgumentException
import java.util.*

class PersonRepository : IPersonRepository {
    private val people: MutableList<Person> = mutableListOf()

    override fun save(person: Person) {
        if (people.any { it.id == person.id })
            throw IllegalArgumentException("people already exists")

        people.add(person)
    }

    override fun update(person: Person) {
        if (!people.any { it.id == person.id })
            throw IllegalArgumentException("people not exists")

        people.forEachIndexed { index, data ->
            if (data.id == person.id)
                people[index] = person
        }
    }

    override fun findById(id: UUID): Optional<Person> {
        val person = people.find { it.id == id }
        return Optional.ofNullable(person)
    }

    override fun findAll(): Collection<Person> {
        return people.toList()
    }
}