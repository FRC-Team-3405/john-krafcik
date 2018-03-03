package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team3405.robot.commands.ReportCommand
import frc.team3405.robot.commands.CompressorOffCommand
import frc.team3405.robot.commands.CompressorOnCommand
import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.Compressor
import edu.wpi.first.wpilibj.PowerDistributionPanel
import edu.wpi.first.wpilibj.Spark


class Reporter: Subsystem() {
    override fun initDefaultCommand() {
        defaultCommand = ReportCommand()
    }

    private val pressure = AnalogInput(0)
    private val pdp = PowerDistributionPanel()

    fun report() {
        //Air Pressure
        SmartDashboard.putNumber("Analog Pressure Sensor Voltage", pressure.voltage)
        SmartDashboard.putNumber("~Pressure (PSI)", analogToUnitPSI(pressure.voltage))

        //Power Distro Totals
        SmartDashboard.putNumber("Power Distro Temperature", pdp.temperature)
        SmartDashboard.putNumber("Power Distro Total Current", pdp.totalCurrent)
        SmartDashboard.putNumber("Power Distro Total Power", pdp.totalPower)
        SmartDashboard.putNumber("Power Distro Total Voltage", pdp.voltage)

        //Power Distro Port Current Draw
        SmartDashboard.putNumber("Power Distro Port 0 Draw", pdp.getCurrent(0))
        SmartDashboard.putNumber("Power Distro Port 1 Draw", pdp.getCurrent(1))
        SmartDashboard.putNumber("Power Distro Port 2 Draw", pdp.getCurrent(2))
        SmartDashboard.putNumber("Power Distro Port 3 Draw", pdp.getCurrent(3))
        SmartDashboard.putNumber("Power Distro Port 16 Draw", pdp.getCurrent(15))
    }

    private val SENSOR_VOLTAGE = 5.0
    private fun analogToUnitPSI(voltage: Double): Double {
        return 250 * (voltage / SENSOR_VOLTAGE) - 25
    }


}