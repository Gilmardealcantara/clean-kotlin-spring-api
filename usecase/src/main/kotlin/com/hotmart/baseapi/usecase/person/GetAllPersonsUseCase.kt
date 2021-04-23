package com.hotmart.baseapi.usecase.person

import com.hotmart.baseapi.domain.entity.Person
import com.hotmart.baseapi.usecase.base.UseCaseResponse
import com.hotmart.baseapi.usecase.person.response.PersonResponse
import org.springframework.stereotype.Service

@Service
class GetAllPersonsUseCase() : IGetAllPersonsUseCase {
    override fun execute(): UseCaseResponse<Collection<PersonResponse>> {
        val all:Collection<Person> = emptyList()
        return UseCaseResponse.setSuccess(all.map { PersonResponse(it) })
    }
}

