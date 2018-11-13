package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class RunGyroscopeCommand: Command() {

    init {
        requires(Robot.gyroscope)
    }

    override fun isFinished() = false

    override fun execute() {
        Robot.gyroscope.report()
    }
}
