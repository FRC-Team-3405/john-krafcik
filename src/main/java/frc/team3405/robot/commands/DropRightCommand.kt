package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class DropRightCommand: Command() {

    init {
        requires(Robot.pneumatics)
    }

    override fun execute() {
        Robot.pneumatics.dropRight()
    }

    override fun isFinished() = true
}