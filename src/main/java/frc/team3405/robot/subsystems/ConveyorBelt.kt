package frc.team3405.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import frc.team3405.robot.commands.BeltCommand

class ConveyorBelt: Subsystem() {
    val motor = Victor(5) //TODO get port number

    override fun initDefaultCommand() {
        defaultCommand = BeltCommand()
    }

    fun moveBelt() {
        val direction = Robot.guitar.tiltBar
        val maxOutput = .3

        when(direction) {
            0 -> motor.set(maxOutput)
            180 -> motor.set(-maxOutput)
        }
    }
}