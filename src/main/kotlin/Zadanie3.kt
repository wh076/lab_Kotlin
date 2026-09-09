package org.example

import java.io.PrintStream

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    val a = (0..10).random()

    while (true) {
        println("Введите число от 0 до 10:")
        val b = readln().toInt()

        if (b > a) {
            println("Много")
        } else if (b < a) {
            println("Мало")
        } else {
            println("Угадал")
            break
        }
    }
}
