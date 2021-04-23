package com.hotmart.baseapi.application.controller

import com.hotmart.baseapi.usecase.person.IGetAllPersonsUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/persons")
open class PersonController(
    private val getAllUseCase: IGetAllPersonsUseCase
) {
    @GetMapping
    fun getAll():ResponseEntity<*> {
        return ResponseEntity.ok(getAllUseCase.execute())
    }
}