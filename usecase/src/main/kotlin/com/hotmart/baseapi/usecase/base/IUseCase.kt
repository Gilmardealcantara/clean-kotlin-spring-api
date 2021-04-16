package com.hotmart.baseapi.usecase.base

interface IUseCase<TRequest, TResponse> {
    fun execute(request: TRequest): UseCaseResponse<TResponse>
}