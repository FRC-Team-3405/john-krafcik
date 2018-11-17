package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.AnalogGyro
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team3405.robot.Sensor
import frc.team3405.robot.commands.RunGyroscopeCommand

class Gyroscope: Subsystem(), Sensor {

    private val gyroscope = AnalogGyro(1)

    override fun initDefaultCommand() {
        defaultCommand = RunGyroscopeCommand()
    }

    fun initialize() {
        gyroscope.initGyro()
    }

    fun calibrate() {
        gyroscope.calibrate()
    }

    fun reset() {
        gyroscope.reset()
    }

    override fun report() {
        SmartDashboard.putNumber("angle", gyroscope.angle)
        SmartDashboard.putNumber("offset", gyroscope.offset)
        SmartDashboard.putNumber("rate", gyroscope.rate)
        SmartDashboard.putNumber("pid", gyroscope.pidGet())
        SmartDashboard.updateValues()
    }


}
