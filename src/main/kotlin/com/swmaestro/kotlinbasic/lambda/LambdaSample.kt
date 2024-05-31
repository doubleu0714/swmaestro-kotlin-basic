package com.swmaestro.kotlinbasic.lambda

val intAppend: (Int, Int) -> String = { prefix: Int, suffix: Int ->
    "$prefix$suffix"
}

fun String.sampleLambda(block: (String) -> Boolean): Boolean {
    val uppercase = this.uppercase()
    return block(uppercase)
}