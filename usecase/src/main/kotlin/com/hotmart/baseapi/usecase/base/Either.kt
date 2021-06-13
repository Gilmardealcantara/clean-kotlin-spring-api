package com.hotmart.baseapi.usecase.base

import java.util.Optional

open class Either<L, R> private constructor(private val left: L?, private val right: R?) {
    companion object {
        fun <L, R> left(value: L): Either<L, R> = Either(value, null)
        fun <L, R> right(value: R): Either<L, R> = Either(null, value)
    }

    fun apply(lFunc: (data: L) -> Any, rFunc: (data: R) -> Any) {
        left?.let(lFunc) ?: right?.let(rFunc)
    }
}

open class EitherResult<V> private constructor(private val left: V?, private val right: ErrorMessage?) {
    companion object {
        fun <V> success(value: V): EitherResult<V> = EitherResult(value, null)
        fun <V> error(value: ErrorMessage): EitherResult<V> = EitherResult(null, value)
    }

    fun apply(lFunc: (data: V) -> Any, rFunc: (error: ErrorMessage) -> Any) {
        left?.let(lFunc) ?: right?.let(rFunc)
    }
}

//typealias Result<V> = Either<ErrorMessage, V>

fun answer(response: Int): EitherResult<Int> {
    if (response == 42)
        return EitherResult.success(42)
    return EitherResult.error(ErrorMessage("aa", "aa"))
}

fun main() {
    answer(41).apply({ println(it) }, { println(it) })
}