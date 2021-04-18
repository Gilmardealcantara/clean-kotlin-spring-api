package com.hotmart.baseapi.usecase.person

import com.hotmart.baseapi.domain.entity.Person
import com.hotmart.baseapi.domain.service.IPersonRepository
import com.hotmart.baseapi.usecase.base.IUseCaseOnlyResponse
import com.hotmart.baseapi.usecase.base.UseCaseResponse
import com.hotmart.baseapi.usecase.person.response.PersonResponse

interface IGetAllPersonsUseCase: IUseCaseOnlyResponse<Collection<PersonResponse>>

class GetAllPersonsUseCase() : IGetAllPersonsUseCase {
    override fun execute(): UseCaseResponse<Collection<PersonResponse>> {
        val all:Collection<Person> = emptyList()
        return UseCaseResponse.setSuccess(all.map { PersonResponse(it) })
    }
}
