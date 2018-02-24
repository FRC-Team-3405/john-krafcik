package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team3405.robot.commands.ReportCommand
import frc.team3405.robot.commands.CompressorOffCommand
import frc.team3405.robot.commands.CompressorOnCommand
import edu.wpi.first.wpilibj.AnalogInput





class Reporter: Subsystem() {
    override fun initDefaultCommand() {
        defaultCommand = ReportCommand()
    }

    private val pressure = AnalogInput(0)

    fun report() {
        SmartDashboard.putBoolean("Running", true)

        //Air Pressure
        SmartDashboard.putNumber("Analog Pressure Voltage", pressure.voltage)
        SmartDashboard.putNumber("~Pressure (PSI)", analogToUnitPSI(pressure.voltage))


    }

    private val SENSOR_VOLTAGE = 5.0
    private fun analogToUnitPSI(voltage: Double): Double {
        return 250 * (voltage / SENSOR_VOLTAGE) - 25
    }


}