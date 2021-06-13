package com.hotmart.baseapi.application.controller

import com.hotmart.baseapi.application.converter.UseCaseResponseConverter
import com.hotmart.baseapi.usecase.person.ICreatePersonUseCase
import com.hotmart.baseapi.usecase.person.IGetAllPersonsUseCase
import com.hotmart.baseapi.usecase.person.IGetPersonByIdUseCase
import com.hotmart.baseapi.usecase.person.request.CreatePersonRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/persons")
class PersonController(
    private val getAllUseCase: IGetAllPersonsUseCase,
    private val getPersonByIdUseCase: IGetPersonByIdUseCase,
    private val createPersonUseCase: ICreatePersonUseCase,
) {
    @GetMapping
    fun getAll(): ResponseEntity<*> = getAllUseCase.execute().let { UseCaseResponseConverter.convert(it, "/persons") }

    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): ResponseEntity<*> =
        getPersonByIdUseCase.execute(id).let { UseCaseResponseConverter.convert(it, "\"/persons\"") }

    @PostMapping
    fun post(@RequestBody request: CreatePersonRequest): ResponseEntity<*> =
        createPersonUseCase.execute(request).let { UseCaseResponseConverter.convert(it, "/persons") }
}