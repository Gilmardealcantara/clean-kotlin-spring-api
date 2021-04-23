package com.hotmart.baseapi.usecase.person

import com.hotmart.baseapi.usecase.base.IUseCaseOnlyResponse
import com.hotmart.baseapi.usecase.person.response.PersonResponse

interface IGetAllPersonsUseCase: IUseCaseOnlyResponse<Collection<PersonResponse>>
