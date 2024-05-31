package com.swmaestro.kotlinbasic.exceptionhandling

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ExceptionHandlingTest: FunSpec({
    fun returnResultFunction(name: String?): Result<String> =
        name?.let{
            Result.success(it.uppercase())
        } ?: Result.failure(IllegalArgumentException("name is null"))

    test("Result 사용") {
        // given

        // when
        val actual: Result<String> = returnResultFunction(name = "swm")

        // then
        actual.onFailure {  }
        actual.onSuccess {  }
        actual.getOrNull()
    }

    fun runCatchingFunction(name: String?): Result<String> =
        runCatching {
            name?.substring(0..100) ?: error("name is null")
        }

    test("runCatching 사용") {
        // given

        // when
        val actual: Result<String> = runCatchingFunction(name = "swm")

        // then
        actual.isFailure shouldBe true
        (actual.exceptionOrNull() is IndexOutOfBoundsException).shouldBeTrue()
    }
})


