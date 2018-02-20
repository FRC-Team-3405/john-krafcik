package frc.team3405.robot.commands

import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.tan

const val HEIGHT = 12.0
const val WIDTH = 6.0

enum class SwitchPosition(val value: Double) {
    RIGHT(1.0),
    LEFT(-1.0)
}


enum class StartingPosition(val value: Double) {
    LEFT(-2.0),
    CENTER(0.0),
    RIGHT(2.0)
}

data class Directions(val angle: Double, val distance: Double)


fun squared(x: Double) = x.pow(2)

fun getDirections(switchPosition: SwitchPosition, startingPosition: StartingPosition): Directions {
    val path = startingPosition.value - switchPosition.value

    val angle = tan(HEIGHT / (WIDTH * path))
    val distance = sqrt(squared(HEIGHT) + squared(WIDTH * path))
    return Directions(angle, distance)
}



