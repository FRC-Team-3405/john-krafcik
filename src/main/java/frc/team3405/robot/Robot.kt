package frc.team3405.robot

import edu.wpi.first.wpilibj.CameraServer
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team3405.robot.commands.AutonomousCommand
import frc.team3405.robot.commands.ShiftDownCommand
import frc.team3405.robot.commands.ShiftUpCommand
import frc.team3405.robot.subsystems.Accelerometer
import frc.team3405.robot.subsystems.DriveTrain
import frc.team3405.robot.subsystems.Gyroscope
import frc.team3405.robot.subsystems.Pneumatics
import kotlinx.coroutines.experimental.launch
import org.opencv.core.Mat


class Robot : IterativeRobot() {
    companion object {
        val driveTrain = DriveTrain()
        val pneumatics = Pneumatics()
//        val reporter = Reporter()
        val gyroscope = Gyroscope()
        val accelerometer = Accelerometer()
        val joystick = XboxController(Joystick(0))

        //Gear shifting buttons
        val highGearButton = JoystickButton(joystick.joystick, Xbox.RightBumper)
        val lowGearButton = JoystickButton(joystick.joystick, Xbox.LeftBumper)
    }

    override fun robotInit() {
        Robot.highGearButton.whenPressed(ShiftUpCommand())
        Robot.lowGearButton.whenPressed(ShiftDownCommand())

        launch {
            val camera = CameraServer.getInstance().startAutomaticCapture()
            camera.setResolution(640, 480)
            val outputStream = CameraServer.getInstance().putVideo("Front", 640, 480)
            val source = Mat()
            while (true) {
                outputStream.putFrame(source)
            }
        }
    }

    override fun disabledInit() {}

    override fun autonomousInit() {
        //Reset all robot subsystems to starting values
        gyroscope.initialize()
        gyroscope.reset()
        pneumatics.shiftDown()
        AutonomousCommand().start()
    }

    override fun teleopInit() {
    }

    override fun testInit() {}


    override fun disabledPeriodic() {}


    override fun autonomousPeriodic() {

    }

    override fun teleopPeriodic() {

    }

    override fun robotPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun testPeriodic() {}
}
