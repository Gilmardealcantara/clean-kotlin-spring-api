package com.hotmart.baseapi.application.config

import com.hotmart.baseapi.usecase.base.UseCaseResponse
import com.hotmart.baseapi.usecase.base.UseCaseResponseType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.lang.IllegalArgumentException
import java.net.URI

class UseCaseResponseConverter {
    companion object {
        fun convert(response: UseCaseResponse<*>): ResponseEntity<*> = when (response.type) {
            UseCaseResponseType.SUCCESS -> ResponseEntity.ok(response)
            UseCaseResponseType.CREATED_SUCCESS -> ResponseEntity.created(URI("")).body(response)
            UseCaseResponseType.VALIDATION_ERROR -> ResponseEntity.badRequest().body(response)
            UseCaseResponseType.NOT_FOUND_RESOURCE -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(response)
            else -> throw IllegalArgumentException("UseCaseResponseType not be converted to application response")
        }
    }
}