package main.java.frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class LiftLeftCommand: Command() {

    init {
        requires(Robot.pneumatics)
    }

    override fun execute() {
        Robot.pneumatics.liftLeft()
    }

    override fun isFinished() = true
}