package frc.team3405.robot

import edu.wpi.first.wpilibj.CameraServer
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team3405.robot.commands.AutonomousCommand
import frc.team3405.robot.commands.ShiftDownCommand
import frc.team3405.robot.commands.ShiftUpCommand
import frc.team3405.robot.subsystems.DriveTrain
import frc.team3405.robot.subsystems.Pneumatics
import kotlinx.coroutines.experimental.launch
import org.opencv.core.Mat


class Robot : IterativeRobot() {
    companion object {
        val driveTrain = DriveTrain()
        val pneumatics = Pneumatics()
//        val reporter = Reporter()
        val joystick = XboxController(Joystick(0))

        //Gear shifting buttons
        val highGearButton = JoystickButton(joystick.joystick, Xbox.RightBumper)
        val lowGearButton = JoystickButton(joystick.joystick, Xbox.LeftBumper)

        val dropWingsButton = JoystickButton(joystick.joystick, Xbox.AButton)
        val liftLeftButton = JoystickButton(joystick.joystick, Xbox.XButton)
        val liftRightButton = JoystickButton(joystick.joystick, Xbox.BButton)
        val dropLeftButton = JoystickButton(joystick.joystick, Xbox.nineButton)
        val dropRightButton = JoystickButton(joystick.joystick, Xbox.tenButton)
    }

    lateinit var autonomousCommand: Command

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
        autonomousCommand = AutonomousCommand()
        autonomousCommand.start()
    }

    override fun teleopInit() {
    }

    override fun testInit() {}


    override fun disabledPeriodic() {}


    override fun autonomousPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun teleopPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun testPeriodic() {}
}
