package org.example

import java.io.PrintStream

class NumberArray(val numbers: IntArray) {

    fun sumOfPositive(): Int {
        var sum = 0
        for (x in numbers) {
            if (x > 0) {
                sum += x
            }
        }
        return sum
    }

    fun product(): Long {
        var result = 1L
        for (x in numbers) {
            result *= x
        }
        return result
    }

    fun average(): Double {
        return numbers.sum().toDouble() / numbers.size
    }
}

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    val array = NumberArray(intArrayOf(3, -2, 5, -7, 8, 1))

    println("Сумма положительных элементов: ${array.sumOfPositive()}")
    println("Произведение элементов массива: ${array.product()}")
    println("Среднее арифметическое: ${array.average()}")
}
