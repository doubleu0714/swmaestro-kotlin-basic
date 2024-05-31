package com.swmaestro.kotlinbasic.property

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class PropertySampleTest : FunSpec({
    context("프로퍼티 테스트") {
        val sut = PropertySample(
            variable = "variable",
            value = "value",
            nullable = null,
            nonNullable = "non-nullable",
        )

        test("getter setter") {
            // given

            // when

            // then
            sut.property shouldBe sut.value
            sut.property = "hello"
            sut.property shouldBe "hello".uppercase()
        }

        test("null을 다루는 방법") {
            // given

            // when
            val test1: String = sut.nullable ?: "otherValue"
            val test2 = sut.nullable?.uppercase()
            val test3 = if (test2 != null) {
                test2.lowercase() // smart cast
            } else null

            // then
            test1 shouldBe "otherValue"
            test2 shouldBe null
            test3 shouldBe null
        }

        test("nullable non-nullabe 타입비교") {
            // given

            // when

            // then
            (sut.nullable is String).shouldBeFalse()
            (sut.nullable is String?).shouldBeTrue()
        }

        test("var val 비교") {
            sut.variable = "mutable"
            // sut.value = "immutable"

            sut.variable shouldBe "mutable"
        }
    }

    context("스마트 캐스트 테스트") {
        val sut: IMember = CommonMember(
            name = "박원형",
            nullable = "non-null value",
            commonMemberProperty = "commonMemberProperty"
        )
        test("타입에 맞는 expression 실행") {
            // given

            // when
            val actual = when (sut) {
                is CommonMember -> sut.commonMemberProperty
                is VIPMember -> sut.vipMemberProperty
            }

            // then
            actual shouldBe "commonMemberProperty"
        }
        test("null 체크 후 cast") {
            // given
            val localVal: String? = "local val is not null"
            var localVar: String? = "local var is not null"

            // when
            val actualLocalVal = if (localVal != null) {
                localVal.uppercase()
            } else {
                null
            }
            val actualLocalVar = localVar.let {
                if (it != null) {
                    it.uppercase()
                } else {
                    it
                }
            }

            // then
            actualLocalVal shouldBe "local val is not null".uppercase()
            actualLocalVar shouldBe "local var is not null".uppercase()
        }
    }
    context("초기화 지연 테스트") {
        val sut = LazyInitializeSample()
        test("lateinit var 지연된 초기화 값") {
            // given

            // when

            // then
            shouldThrow<UninitializedPropertyAccessException> { sut.lateInitVar.uppercase() }
            sut.lateInitVar = "initialized"
            sut.lateInitVar shouldBe "initialized"
            sut.lazyVal shouldBe "lazyFunction"
            sut.lazyVal
            sut.lazyVal
            lazyFunctionCallCount shouldBe 1
        }
    }
})