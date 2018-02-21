package frc.team3405.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import frc.team3405.robot.commands.DriveCommand

class DriveTrain : Subsystem() {
    private val frontRight: TalonSRX = TalonSRX(0) //Right Bottom
    private val frontLeft: TalonSRX = TalonSRX(1) //Left Top
    private val backLeft: TalonSRX = TalonSRX(2) //Left Bottom
    private val backRight: TalonSRX = TalonSRX(3) //Right Top

    override fun initDefaultCommand() {
        defaultCommand = DriveCommand()
    }

    fun arcadeDrive() {
        val x = Robot.joystick.leftX
        val y = Robot.joystick.leftY
        val maxOutput = .7
        val left: Double = (y - x) * maxOutput
        val right: Double = (y + x) * maxOutput

        frontRight.set(ControlMode.PercentOutput, -right)
        backRight.set(ControlMode.PercentOutput, -right)

        frontLeft.set(ControlMode.PercentOutput, left)
        backLeft.set(ControlMode.PercentOutput, left)
    }

    //For Eastmond
    fun tankDrive() {
        val leftY = Robot.joystick.leftY
        val rightY = Robot.joystick.rightY
        val maxOutput = .7
        val left: Double = leftY * maxOutput
        val right: Double = rightY * maxOutput

        frontLeft.set(ControlMode.PercentOutput, left)
        backLeft.set(ControlMode.PercentOutput, left)

        frontRight.set(ControlMode.PercentOutput, -right)
        backRight.set(ControlMode.PercentOutput, -right)
    }
}

