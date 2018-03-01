package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class DropLeftCommand: Command() {

    init {
        requires(Robot.pneumatics)
    }

    override fun execute() {
        Robot.pneumatics.dropLeft()
    }

    override fun isFinished() = true
}