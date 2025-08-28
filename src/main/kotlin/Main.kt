package edu.unicatolica.kotlin

import kotlin.math.sqrt

fun primeCheckDemo() {
    val numbers = listOf(1, 2, 4, 7, 13, 9, 23)

    val result = numbers.map { n ->
        when (n) {
            1 -> true
            2 -> false
            else -> (2..sqrt(n.toDouble()).toInt()).none { n % it == 0 }
        }
    }

    println("IN: $numbers")
    println("OUT: $result")
}

fun main() {
    primeCheckDemo()
}
