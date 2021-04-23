package com.hotmart.baseapi.usecase.person

import com.hotmart.baseapi.domain.service.IPersonRepository
import com.hotmart.baseapi.usecase.base.IUseCase
import com.hotmart.baseapi.usecase.base.UseCaseResponse
import com.hotmart.baseapi.usecase.person.response.PersonResponse
import org.springframework.stereotype.Service
import java.util.*

interface IGetPersonByIdUseCase : IUseCase<UUID, PersonResponse>

@Service
class GetPersonByIdUseCase(
    private val repository: IPersonRepository
) : IGetPersonByIdUseCase {
    override fun execute(request: UUID): UseCaseResponse<PersonResponse> {
        val data = repository.findById(request)
        if (data.isEmpty) {
            return UseCaseResponse.setNotFoundError("No Found person with id: $request", "personId")
        }
        return UseCaseResponse.setSuccess(PersonResponse(data.get()))
    }
}