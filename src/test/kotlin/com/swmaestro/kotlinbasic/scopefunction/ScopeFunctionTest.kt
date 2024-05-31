package com.swmaestro.kotlinbasic.scopefunction

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.util.Properties

class ScopeFunctionTest: FunSpec({
    listOf(
        null to "null",
        "test" to "Test"
    ).forAll {(sutVal, result) ->
        test("let 을 사용한다($sutVal, $result)") {
            // given
            val sut: String? = sutVal

            // when
            val actual: String = sut?.let {
                result
            } ?: result

            // then
            actual shouldBe result
        }
    }

    test("apply 를 사용한다") {
        // given
        val sut: Properties = Properties().apply {
            set("prop1", "val1")
            set("prop2", "val2")
            set("prop3", "val3")
        }

        // when

        // then
        sut.get("prop1") shouldBe "val1"
        sut.get("prop2") shouldBe "val2"
        sut.get("prop3") shouldBe "val3"
    }
})
