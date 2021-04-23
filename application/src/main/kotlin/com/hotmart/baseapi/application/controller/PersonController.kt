package com.hotmart.baseapi.application.controller

import com.hotmart.baseapi.application.config.UseCaseResponseConverter
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
class PersonController(
    private val getAllUseCase: IGetAllPersonsUseCase,
    private val getPersonByIdUseCase: IGetPersonByIdUseCase
) {
    @GetMapping
    fun getAll(): ResponseEntity<*> = getAllUseCase.execute().let { UseCaseResponseConverter.convert(it) }

    @GetMapping("{id}")
    fun get(@PathVariable id: UUID): ResponseEntity<*> =
        getPersonByIdUseCase.execute(id).let { UseCaseResponseConverter.convert(it) }
}