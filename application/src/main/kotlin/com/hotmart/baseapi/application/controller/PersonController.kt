package com.hotmart.baseapi.application.controller

import com.hotmart.baseapi.usecase.person.IGetAllPersonsUseCase
import com.hotmart.baseapi.usecase.person.IGetPersonByIdUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/persons")
open class PersonController(
    private val getAllUseCase: IGetAllPersonsUseCase,
    private val getPersonByIdUseCase: IGetPersonByIdUseCase
) {
    @GetMapping
    fun getAll(): ResponseEntity<*> {
        return ResponseEntity.ok(getAllUseCase.execute())
    }

    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): ResponseEntity<*> {
        return ResponseEntity.ok(getPersonByIdUseCase.execute(id))
    }
}