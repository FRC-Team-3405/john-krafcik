package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot
import kotlin.math.atan
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.tan

const val HEIGHT = 11.66666666

enum class SwitchPosition(val value: Double) {
    RIGHT(4.5),
    LEFT(-4.5)
}


enum class StartingPosition(val value: Double) {
    LEFT(-8.0),
    CENTER(2.0),
    RIGHT(8.0)
}

data class Directions(val angle: Double, val distance: Double)


fun squared(x: Double) = x.pow(2)

fun getDirections(switchPosition: SwitchPosition, startingPosition: StartingPosition): Directions {
    val path = startingPosition.value - switchPosition.value

    val angle = atan(HEIGHT / path)
    val distance = sqrt(squared(HEIGHT) + squared(path))
    return Directions(angle, distance)
}

class AutonomousCommand: Command() {

    init {
        requires(Robot.pneumatics)
        requires(Robot.driveTrain)
        requires(Robot.conveyor)
    }
    override fun isFinished() = true

    override fun execute() {
        Robot.pneumatics.shiftDown()
        Robot.driveTrain.driveTime(3.0)
        when(DriverStation.getInstance().gameSpecificMessage[0]) {
            'L' -> {

            }
            'R' -> {
                Robot.conveyor.moveBeltTimed(3.0)
            }
        }
    }

}
