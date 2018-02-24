package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class ShiftDownCommand: Command() {

    init {
        requires(Robot.pneumatics)
    }

    override fun isFinished() = true

    override fun execute() {
        Robot.pneumatics.shiftDown()
    }

}