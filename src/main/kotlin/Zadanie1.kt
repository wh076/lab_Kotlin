package org.example

import java.io.PrintStream

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    println("Введите целое положительное число:")
    val number = readln().toInt()

    var temp = number
    while (temp >= 10) {
        temp /= 10
    }
    val firstDigit = temp
    val lastDigit = number % 10

    println("Сумма первой и последней цифры: ${firstDigit + lastDigit}")
}
