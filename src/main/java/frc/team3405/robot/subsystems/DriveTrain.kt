package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import frc.team3405.robot.commands.DriveCommand

class DriveTrain : Subsystem() {
    private val frontRight: Talon = Talon(0)
    private val frontLeft: Talon = Talon(1)
    private val backLeft: Talon = Talon(2)
    private val backRight: Talon = Talon(3)

    override fun initDefaultCommand() {
        defaultCommand = DriveCommand()
    }

    fun arcadeDrive() {
        val x = Robot.joystick.leftX
        val y = Robot.joystick.leftY
        val maxOutput = .7
        val left: Double = (y - x) * maxOutput
        val right: Double = (y + x) * maxOutput

        frontRight.set(right)
        backRight.set(right)

        frontLeft.set(-left)
        backLeft.set(-left)
    }

}

