package org.example

import java.io.PrintStream

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    val array = arrayOf(2, 4, 6, 3, 8, 1)

    println("Цикл for:")
    var productFor = 1
    for (x in array) {
        productFor *= x
    }
    println("Произведение: $productFor")

    println("Цикл while:")
    var productWhile = 1
    var i = 0
    while (i < array.size) {
        productWhile *= array[i]
        i++
    }
    println("Произведение: $productWhile")

    println("forEach:")
    var productForEach = 1
    array.forEach { productForEach *= it }
    println("Произведение: $productForEach")

    println("reduce():")
    val productReduce = array.reduce { acc, x -> acc * x }
    println("Произведение: $productReduce")

    println("min() и max():")
    println("Минимум: ${array.min()}")
    println("Максимум: ${array.max()}")
}
