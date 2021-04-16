package com.hotmart.baseapi.usecase.person

import com.hotmart.baseapi.domain.service.IPersonRepository
import com.hotmart.baseapi.usecase.base.IUseCase
import com.hotmart.baseapi.usecase.base.UseCaseResponse
import com.hotmart.baseapi.usecase.person.request.UpdatePersonRequest
import com.hotmart.baseapi.usecase.person.response.PersonResponse

class UpdatePersonUseCase(
    private val repository: IPersonRepository
) : IUseCase<UpdatePersonRequest, PersonResponse> {
    override fun execute(request: UpdatePersonRequest): UseCaseResponse<PersonResponse> {
        val personOp = repository.findById(request.id)
        return if (personOp.isPresent) {
            val person = personOp.get()
            person.changeName(request.name)
            UseCaseResponse.setSuccess(PersonResponse(person))
        } else {
            UseCaseResponse.setNotFoundError("Not found person with id ${request.id}", "person id")
        }
    }
}