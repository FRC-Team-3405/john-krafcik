package frc.team3405.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.wpi.first.wpilibj.RobotDrive
import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.drive.MecanumDrive
import edu.wpi.first.wpilibj.drive.RobotDriveBase
import frc.team3405.robot.Robot
import frc.team3405.robot.commands.DriveCommand

class DriveTrain : Subsystem() {
    private val frontRight: TalonSRX = TalonSRX(0)
    private val frontLeft: TalonSRX = TalonSRX(1)
    private val backLeft: TalonSRX = TalonSRX(2)
    private val backRight: TalonSRX = TalonSRX(3)

    override fun initDefaultCommand() {
        defaultCommand = DriveCommand()
    }

    fun arcadeDrive() {
        val x = Robot.joystick.leftX
        val y = Robot.joystick.leftY
        val maxOutput = .7
        val left: Double = (y - x) * maxOutput
        val right: Double = (y + x) * maxOutput

        frontRight.set(ControlMode.PercentOutput, right)
        backRight.set(ControlMode.PercentOutput, right)

        frontLeft.set(ControlMode.PercentOutput, -left)
        backLeft.set(ControlMode.PercentOutput, -left)
    }
}

