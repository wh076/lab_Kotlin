package org.example

import java.io.PrintStream

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    println("Введите количество простых чисел:")
    val n = readln().toInt()

    var count = 0
    var number = 2
    while (count < n) {
        var isPrime = true
        var divisor = 2
        while (divisor * divisor <= number) {
            if (number % divisor == 0) {
                isPrime = false
                break
            }
            divisor++
        }
        if (isPrime) {
            count++
            println("$count-ое число: $number")
        }
        number++
    }
}
