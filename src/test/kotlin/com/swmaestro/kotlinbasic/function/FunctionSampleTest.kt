package com.swmaestro.kotlinbasic.function

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FunctionSampleTest : FunSpec({
    test("top level function을 호출한다") {
        // given

        // when
        val actual: String = topLevelFunction()

        // then
        actual shouldBe "I'm top level function"
    }

    test("확장함수를 호출한다") {
        // given
        val sut = FunctionSample("swm")

        // when
        val actual: String = sut.itIsExtensionFunction()

        // then
        actual shouldBe "Hello! SWM"
        sut.itIsExtensionProperty shouldBe "SWM"
    }

    test("default argument 함수를 호출한다") {
        // given

        // when
        val actual = defaultArguments(hello = "Hi")

        // then
        actual shouldBe "Hi swm"
    }
})

fun FunctionSample.itIsExtensionFunction(): String =
    "Hello! ${name.uppercase()}"
val FunctionSample.itIsExtensionProperty: String
    get() = name.uppercase()


fun defaultArguments(name: String = "swm", hello: String): String =
    "$hello $name"

