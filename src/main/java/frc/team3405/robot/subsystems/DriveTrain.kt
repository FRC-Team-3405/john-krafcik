package frc.team3405.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import frc.team3405.robot.Xbox
import frc.team3405.robot.commands.DriveCommand
import kotlin.math.max

class



DriveTrain : Subsystem() {
    private val frontRight: TalonSRX = TalonSRX(0) //Right Bottom
    private val frontLeft: TalonSRX = TalonSRX(1) //Left Top
    private val backLeft: TalonSRX = TalonSRX(2) //Left Bottom
    private val backRight: TalonSRX = TalonSRX(3) //Right Top

    override fun initDefaultCommand() {
        defaultCommand = DriveCommand()
    }

    fun arcadeDrive() {
        val x = Robot.joystick.leftX * .7
        val y = Robot.joystick.leftY
        var maxOutput = .7
        if(Robot.joystick.joystick.getRawButton(Xbox.LeftLowerBumper)) {
            maxOutput += .2
        }
        val left: Double = (y - x) * maxOutput
        val right: Double = (y + x) * maxOutput

        frontRight.set(ControlMode.PercentOutput, -right)
        backRight.set(ControlMode.PercentOutput, -right)

        frontLeft.set(ControlMode.PercentOutput, left)
        backLeft.set(ControlMode.PercentOutput, left)
    }

    //For Eastmond
    fun tankDrive() {
        val leftY = Robot.joystick.leftY * 0.7
        val rightY = Robot.joystick.rightY * 0.7
        var maxOutput = .9
        if(Robot.joystick.joystick.getRawButton(Xbox.RightLowerBumper)) {
            maxOutput += .2
        } else if(Robot.joystick.joystick.getRawButton(Xbox.LeftLowerBumper)) {
            maxOutput -= .3
        }

        val left: Double = leftY * maxOutput
        val right: Double = rightY * maxOutput

        frontLeft.set(ControlMode.PercentOutput, left)
        backLeft.set(ControlMode.PercentOutput, left)

        frontRight.set(ControlMode.PercentOutput, -right)
        backRight.set(ControlMode.PercentOutput, -right)

        when(Robot.joystick.povController) {
            0 -> {
                frontLeft.set(ControlMode.PercentOutput, -.5)
                backLeft.set(ControlMode.PercentOutput, -.5)

                frontRight.set(ControlMode.PercentOutput, .5)
                backRight.set(ControlMode.PercentOutput, .5)
            }
            180 -> {
                frontLeft.set(ControlMode.PercentOutput, .5)
                backLeft.set(ControlMode.PercentOutput, .5)

                frontRight.set(ControlMode.PercentOutput, -.5)
                backRight.set(ControlMode.PercentOutput, -.5)
            }
        }
    }

    fun driveForward() {

    }

    fun driveTime(seconds: Double) {
        val timer = Timer()
        timer.reset()
        timer.start()

        while (timer.get() < seconds) {
            frontLeft.set(ControlMode.PercentOutput, -0.5)
            backLeft.set(ControlMode.PercentOutput, -0.5)

            frontRight.set(ControlMode.PercentOutput, 0.5)
            backRight.set(ControlMode.PercentOutput, 0.5)
        }

        timer.stop()


        frontLeft.set(ControlMode.PercentOutput, 0.0)
        backLeft.set(ControlMode.PercentOutput, 0.0)

        frontRight.set(ControlMode.PercentOutput, 0.0)
        backRight.set(ControlMode.PercentOutput, 0.0)

    }

    fun makeMotorsEncoders(vararg listOfMotors:TalonSRX) {
        listOfMotors.forEach { talon ->
            talon.apply {
            }
            talon.changeControlMode(ControlMode.Position); //Change control mode of talon, default is PercentVbus (-1.0 to 1.0)
            talon.setFeedbackDevice(FeedbackDevice.QuadEncoder); //Set the feedback device that is hooked up to the talon
            talon.setPID(0.5, 0.001, 0.0); //Set the PID constants (p, i, d)
            talon.enableControl(); //Enable PID control on the talon
        }
    }

}

