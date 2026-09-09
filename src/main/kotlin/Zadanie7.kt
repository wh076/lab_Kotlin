package org.example

import java.io.PrintStream
import kotlin.math.sqrt

fun sqr(n: Double): Double {
    return n * n
}

fun discriminant(a: Double, b: Double, c: Double): Double {
    return sqr(b) - 4 * a * c
}

fun rootsNumber(a: Double, b: Double, c: Double): Int {
    val d = discriminant(a, b, c)
    return when {
        d > 0 -> 2
        d == 0.0 -> 1
        else -> 0
    }
}

fun quadraticRoot(a: Double, b: Double, c: Double) {
    val d = discriminant(a, b, c)
    when (rootsNumber(a, b, c)) {
        2 -> {
            val x1 = (-b + sqrt(d)) / (2 * a)
            val x2 = (-b - sqrt(d)) / (2 * a)
            println("Корни уравнения: x1 = $x1, x2 = $x2")
        }
        1 -> {
            val x = -b / (2 * a)
            println("Корень уравнения: x = $x")
        }
        else -> {
            println("Действительных корней нет")
        }
    }
}

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    println("Введите коэффициенты a, b, c по очереди:")
    val a = readln().toDouble()
    val b = readln().toDouble()
    val c = readln().toDouble()

    quadraticRoot(a, b, c)
}
