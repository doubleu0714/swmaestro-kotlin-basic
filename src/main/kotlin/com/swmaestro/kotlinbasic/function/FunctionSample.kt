package com.swmaestro.kotlinbasic.function

fun topLevelFunction(): String {
    return "I'm top level function"
}

class FunctionSample(
    val name: String
) {
    fun singleExpressionFunction(condition: Boolean): String =
        if (condition) {
            "Y"
        } else {
            "N"
        }
}