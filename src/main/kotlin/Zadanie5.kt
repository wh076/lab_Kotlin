package org.example

import java.io.PrintStream

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    val array = arrayOf(1, 5, 2, 8, 3, 9, 4, 7)

    println("С использованием for:")
    for (i in 1 until array.size - 1) {
        if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
            println(array[i])
        }
    }

    println("С использованием while:")
    var i = 1
    while (i < array.size - 1) {
        if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
            println(array[i])
        }
        i++
    }

    println("С использованием forEach:")
    array.forEachIndexed { index, value ->
        if (index > 0 && index < array.size - 1 && value > array[index - 1] && value > array[index + 1]) {
            println(value)
        }
    }
}
