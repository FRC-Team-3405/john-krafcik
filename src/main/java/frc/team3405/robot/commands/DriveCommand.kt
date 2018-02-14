package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class DriveCommand : Command() {

    init {
        requires(Robot.driveTrain)
    }

    override fun execute() {
        Robot.driveTrain.mechanumDrive()
    }

    override fun isFinished(): Boolean = false
}