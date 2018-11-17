package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class DriveCommand : Command() {

    init {
        requires(Robot.driveTrain)
    }

    override fun execute() {
        if(Robot.tankDrive) {
            Robot.driveTrain.tankDrive()
        } else {
            Robot.driveTrain.arcadeDrive()
        }
    }

    override fun isFinished(): Boolean = false
}