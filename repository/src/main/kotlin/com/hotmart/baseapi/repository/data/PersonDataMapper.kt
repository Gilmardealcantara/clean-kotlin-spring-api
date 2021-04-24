package com.hotmart.baseapi.repository.data

import com.hotmart.baseapi.domain.entity.Person
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "person")
data class PersonDataMapper(
    @Id @Column(name = "id", length = 16, unique = true, nullable = false)
    val id: UUID,
    val name: String
) {
    constructor(person: Person) : this(person.id, person.name)
    fun toModel(): Person = Person(id, name)
}