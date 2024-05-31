package com.swmaestro.kotlinbasic.`class`

import io.kotest.assertions.fail
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ClassSampleTest : FunSpec({
    context("class 테스트") {
        test("data class 를 생성한다") {
            // given

            val sut = DataClassSample(name = "swm", age = 10)
            val other = DataClassSample(name = "swm", age = 10)

            // when

            // then
            sut.equals(other).shouldBeTrue()
            val (name, age) = sut
            name shouldBe "swm"
            age shouldBe 10
            sut.copy(name = "copied").equals(sut).shouldBeFalse()
        }

        test("object class 를 사용한다") {
            // given

            // when

            // then
            SingletonSample.name shouldBe ""
            SingletonSample.singletonMethod(name = "swm")
            SingletonSample.name shouldBe "swm"
        }

        test("sealed class 를 사용한다") {
            // given
            val sut: SealedParentSample = SealedChild1Class(childName = "child1")

            // when
            val actual: String = when(sut) {
                is SealedChild1Class -> "is 1"
                is SealedChild2Class -> "is 2"
            }

            // then
            actual shouldBe "is 1"
        }

        test("functaional interface를 사용한다.") {
            // given
            val sut = StringChecker { s ->
                s.length <= 10
            }
            val target = "0123456789"

            // when
            val actual = sut.check(target)

            // then
            actual shouldBe true
        }

        test("java functional interface 를 사용한다") {
            // given
            val countDownLatch = CountDownLatch(1)
            val sut = Runnable {
                countDownLatch.countDown()
            }

            // when
            Executors.newSingleThreadExecutor().execute(sut)

            // then
            val await: Boolean = countDownLatch.await(3, TimeUnit.SECONDS)
            if(!await) {
                fail("테스트 실패")
            }
        }
    }
})