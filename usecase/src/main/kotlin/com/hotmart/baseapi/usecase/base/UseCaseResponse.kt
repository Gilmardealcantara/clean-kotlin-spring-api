package com.hotmart.baseapi.usecase.base

class UseCaseResponse<TResponse>(
    val type: UseCaseResponseType,
    val data: TResponse? = null,
    val error: ErrorMessage? = null,
) {

    companion object {
        fun <TResponse> setSuccess(data: TResponse): UseCaseResponse<TResponse> =
            UseCaseResponse(UseCaseResponseType.SUCCESS, data = data)

        fun <TResponse> setValidationError(message: String, field: String): UseCaseResponse<TResponse> {
            return UseCaseResponse(UseCaseResponseType.VALIDATION_ERROR, error = ErrorMessage(message, field))
        }

        fun <TResponse> setNotFoundError(message: String, field: String): UseCaseResponse<TResponse> {
            return UseCaseResponse(UseCaseResponseType.NOT_FOUND_RESOURCE, error = ErrorMessage(message, field))
        }
    }
}