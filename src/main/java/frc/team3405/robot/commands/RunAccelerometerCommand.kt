package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class RunAccelerometerCommand: Command() {

    init {
        requires(Robot.accelerometer)
    }

    override fun isFinished() = false

    override fun execute() {
        Robot.accelerometer.report()
    }

}
