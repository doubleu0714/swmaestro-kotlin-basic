package com.swmaestro.kotlinbasic.`class`

class ClassSample(
    val name: String,
) {
    fun hello(): String =
        "Hello $name"
}

open class OpenClassSample(
    open val name: String,
) {
    fun hello(): String =
        "Hello $name"
}

class OpenChildClassSample(
    override val name: String
): OpenClassSample(name = name)

data class DataClassSample(
    val name: String,
    val age: Int
)

object SingletonSample {
    var name: String = ""
        private set

    fun singletonMethod(name: String): String {
        this.name = name
        return this.name
    }
}

sealed class SealedParentSample(
    val name: String
) {
    abstract fun hello(): String
}

class SealedChild1Class(
    val childName: String
): SealedParentSample(name = childName) {
    override fun hello(): String = "Hello Child1"
}

class SealedChild2Class(
    val childName: String
): SealedParentSample(name = childName) {
    override fun hello(): String = "Hello Child2"
}

fun interface StringChecker {
    fun check(s: String): Boolean
}