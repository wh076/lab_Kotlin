package org.example

import java.io.PrintStream
import kotlin.math.sqrt

class Vector(val x: Double, val y: Double, val z: Double) {

    fun length(): Double {
        return sqrt(x * x + y * y + z * z)
    }

    infix fun dot(other: Vector): Double {
        return x * other.x + y * other.y + z * other.z
    }

    operator fun times(other: Vector): Double {
        return x * other.x + y * other.y + z * other.z
    }
}

fun dotProduct(v1: Vector, v2: Vector): Double {
    return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z
}

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    val v1 = Vector(1.0, 2.0, 3.0)
    val v2 = Vector(3.0, 2.0, 1.0)

    println("Длина вектора v1: ${v1.length()}")
    println("Скалярное произведение (метод): ${v1.dot(v2)}")
    println("Скалярное произведение (инфиксная запись): ${v1 dot v2}")
    println("Скалярное произведение (оператор *): ${v1 * v2}")
    println("Скалярное произведение (внешняя функция): ${dotProduct(v1, v2)}")
}
