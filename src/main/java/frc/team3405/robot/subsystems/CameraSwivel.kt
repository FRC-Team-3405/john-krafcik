package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.Servo
import edu.wpi.first.wpilibj.command.Subsystem
import frc.team3405.robot.Robot
import frc.team3405.robot.Xbox
import frc.team3405.robot.commands.CameraSwivelCommand

class CameraSwivel: Subsystem() {
    private val side = Servo(1)
    private val bottom = Servo(2)

    var motorVelocity = 2.0

    override fun initDefaultCommand() {
        defaultCommand = CameraSwivelCommand()
    }

    fun resetServos() {
        side.angle = 0.0
        bottom.angle = 90.0
    }

    fun updateServos() {
        println("int: ${Robot.joystick.povController}")
        when(Robot.joystick.povController) {
            0 -> {
                if(side.angle + motorVelocity > 90) return
                side.angle += motorVelocity
            }
            90 -> {
                bottom.angle += motorVelocity
            }
            180 -> {
                side.angle -= motorVelocity
            }
            270 -> {
                bottom.angle -= motorVelocity
            }
        }
        if(Robot.joystick.joystick.getRawButtonPressed(Xbox.elevenButton)) {
            side.angle = 0.0
            bottom.angle = 90.0
        }
        println(side.angle)
        println(bottom.angle)
    }
}