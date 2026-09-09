package org.example

import java.io.PrintStream

open class Vehicle {
    open var speed: Int = 0
    open var name: String = "Транспортное средство"

    open fun start() {
        println("$name начал движение со скоростью $speed км/ч")
    }

    open fun stop() {
        println("$name остановился")
    }
}

class Boat : Vehicle() {
    override var speed: Int = 40
    override var name: String = "Лодка"
}

class Plane : Vehicle() {
    override var speed: Int = 800
    override var name: String = "Самолет"
}

class Tank : Vehicle() {
    override var speed: Int = 60
    override var name: String = "Танк"
}

fun main() {
    System.setOut(PrintStream(System.out, true, "UTF-8"))

    val vehicles = listOf(Boat(), Plane(), Tank())
    for (vehicle in vehicles) {
        vehicle.start()
        vehicle.stop()
    }
}
