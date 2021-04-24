package com.hotmart.baseapi.usecase.person

import com.hotmart.baseapi.domain.service.IPersonRepository
import com.hotmart.baseapi.usecase.base.UseCaseResponseType
import com.hotmart.baseapi.usecase.person.request.CreatePersonRequest
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CreatePersonUseCaseTest {
    @Test
    fun `Should create person`() {
        val repository: IPersonRepository = mockk() {
            every { save(any()) } answers {}
        }
        val useCase = CreatePersonUseCase(repository)
        val response = useCase.execute(CreatePersonRequest("Gilmar"))

        Assertions.assertThat(response.type).isEqualTo(UseCaseResponseType.CREATED_SUCCESS)
    }
}