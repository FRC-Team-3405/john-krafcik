package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.BuiltInAccelerometer
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team3405.robot.Sensor
import frc.team3405.robot.commands.RunAccelerometerCommand

class Accelerometer: Subsystem(), Sensor {

    private val accelerometer = BuiltInAccelerometer()

    override fun initDefaultCommand() {
        defaultCommand = RunAccelerometerCommand()
    }

    override fun report() {
        SmartDashboard.putNumber("accelX", accelerometer.x)
        SmartDashboard.putNumber("accelY", accelerometer.y)
        SmartDashboard.putNumber("accelZ", accelerometer.z)
        SmartDashboard.updateValues()
    }

}
