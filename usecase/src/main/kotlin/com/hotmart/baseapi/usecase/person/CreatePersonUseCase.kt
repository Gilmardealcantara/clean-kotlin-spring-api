package com.hotmart.baseapi.usecase.person

import com.hotmart.baseapi.domain.entity.Person
import com.hotmart.baseapi.domain.service.IPersonRepository
import com.hotmart.baseapi.usecase.base.IUseCase
import com.hotmart.baseapi.usecase.base.UseCaseResponse
import com.hotmart.baseapi.usecase.person.request.CreatePersonRequest
import com.hotmart.baseapi.usecase.person.response.PersonResponse
import org.springframework.stereotype.Service

interface ICreatePersonUseCase: IUseCase<CreatePersonRequest, PersonResponse>

@Service
class CreatePersonUseCase(
    private val repository: IPersonRepository
) : ICreatePersonUseCase {
    override fun execute(request: CreatePersonRequest): UseCaseResponse<PersonResponse> {
        val person: Person = request.toModel()
        repository.save(person)
        return UseCaseResponse.setPersisted(PersonResponse(person))
    }
}

