package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.DriverStation
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot
import kotlin.math.atan
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.tan



data class Directions(val angle: Double, val distance: Double)

class AutonomousCommand: Command() {

    init {
        requires(Robot.pneumatics)
        requires(Robot.driveTrain)
    }
    override fun isFinished() = true

    override fun execute() {
        Robot.driveTrain.driveTime(3.0)
//        DriverStation.getInstance().gameSpecificMessage
    }

}
