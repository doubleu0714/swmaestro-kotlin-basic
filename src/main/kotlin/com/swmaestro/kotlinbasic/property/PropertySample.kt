package com.swmaestro.kotlinbasic.property

data class PropertySample(
    var variable: String,
    val value: String,
    internal val nullable: String?,
    val nonNullable: String,
) {
    var property: String = value
        get() = field
        set(newValue) {
            field = newValue.uppercase()
        }
}

class ConstructorProperty(
    val property: String
)

class NonConstructorProperty(
    property: String
) {
    val property: String = property
}

sealed interface IMember {
    val name: String
    var nullable: String?
}

class CommonMember(
    override val name: String,
    override var nullable: String?,
    val commonMemberProperty: String,
) : IMember

class VIPMember(
    override val name: String,
    override var nullable: String?,
    val vipMemberProperty: String,
) : IMember

class LazyInitializeSample {
    lateinit var lateInitVar: String
    val lazyVal: String by lazy {
        lazyFunctionCallCount++
        lazyFunction()
    }
}

fun lazyFunction(): String {
    return "lazyFunction"
}

var lazyFunctionCallCount: Int = 0