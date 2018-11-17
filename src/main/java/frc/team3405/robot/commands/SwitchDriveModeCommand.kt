package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class SwitchDriveModeCommand: Command() {
    override fun isFinished() = true

    override fun execute() {
        Robot.tankDrive = !Robot.tankDrive
    }
}