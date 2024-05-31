package com.swmaestro.kotlinbasic.lambda

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LambdaSampleTest : FunSpec({
    test("람다를 호출한다") {
        // given

        // when
        val actual: String = intAppend(123, 456)

        // then
        actual shouldBe "123456"
    }
})