package org.example

import java.io.PrintStream

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    var count = 0
    var sum = 0

    println("Вводите числа по одному, для завершения введите 0:")
    while (true) {
        val number = readln().toInt()
        if (number == 0) {
            break
        }
        count++
        sum += number
    }

    println("Количество введенных чисел: $count")
    println("Сумма: $sum")
    if (count > 0) {
        println("Среднее арифметическое: ${sum.toDouble() / count}")
    }
}
