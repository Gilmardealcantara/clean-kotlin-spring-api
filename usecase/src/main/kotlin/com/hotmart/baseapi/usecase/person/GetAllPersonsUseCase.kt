package com.hotmart.baseapi.usecase.person

import com.hotmart.baseapi.domain.entity.Person
import com.hotmart.baseapi.domain.service.IPersonRepository
import com.hotmart.baseapi.usecase.base.IUseCaseOnlyResponse
import com.hotmart.baseapi.usecase.base.UseCaseResponse
import com.hotmart.baseapi.usecase.person.response.PersonResponse
import org.springframework.stereotype.Service

interface IGetAllPersonsUseCase: IUseCaseOnlyResponse<Collection<PersonResponse>>

@Service
open class GetAllPersonsUseCase(
    private val repository: IPersonRepository
) : IGetAllPersonsUseCase {
    override fun execute(): UseCaseResponse<Collection<PersonResponse>> {
        val all:Collection<Person> = repository.findAll()
        return UseCaseResponse.setSuccess(all.map { PersonResponse(it) })
    }
}

