package frc.team3405.robot.subsystems

import com.ctre.phoenix.motorcontrol.ControlMode
import com.ctre.phoenix.motorcontrol.can.TalonSRX
import edu.wpi.first.wpilibj.Spark
import edu.wpi.first.wpilibj.Talon
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.Victor
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Guitar
import frc.team3405.robot.Robot
import frc.team3405.robot.Xbox
import frc.team3405.robot.commands.BeltCommand

class ConveyorBelt: Subsystem() {
    val motor = Spark(0)

    override fun initDefaultCommand() {
        defaultCommand = BeltCommand()
    }

    var moving = false

    fun moveBelt() {                                                      motor
//        val direction = Robot.guitar.tiltBar
        var maxOutput = .7
//        if(Robot.guitar.joystick.getRawButton(Guitar.greenButton)) {
//            maxOutput = .9
//        }
        moving = false
//        when(direction) {
//            0 -> {
//                motor.set(maxOutput)
//                moving = true
//            }
//            180 -> {
//                motor.set(-maxOutput)
//                moving = true
//            }
//        }

        if(Robot.joystick.joystick.getRawButton(Xbox.tenButton)) {
            motor.set(-maxOutput)
            moving = true
        } else if(Robot.joystick.joystick.getRawButton(Xbox.nineButton)) {
            motor.set(maxOutput)
            moving = true
        }

        if(!moving) {
            motor.set(0.0)
        }
    }

    fun moveBeltTimed(seconds: Double) {
        var maxOutput = .9
        motor.set(maxOutput)
        val timer = Timer().apply {
            reset()
            start()
        }
        while(timer.get() < seconds) {

        }
        timer.stop()
        motor.set(0.0)
    }
}
