package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class CameraSwivelCommand: Command() {

    init {
        requires(Robot.cameraSwivel)
    }

    override fun isFinished() = false

    override fun execute() {
        println("Servos!")
        Robot.cameraSwivel.updateServos()
    }

}