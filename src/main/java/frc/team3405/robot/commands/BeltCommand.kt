package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class BeltCommand: Command() {
    init {
        requires(Robot.conveyor)
    }

    override fun execute() {
//        Robot.conveyor.moveBelt()
    }

    override fun isFinished(): Boolean = false
}