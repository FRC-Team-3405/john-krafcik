package frc.team3405.robot

import edu.wpi.first.wpilibj.CameraServer
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team3405.robot.commands.*
import frc.team3405.robot.subsystems.ConveyorBelt
import frc.team3405.robot.subsystems.DriveTrain
import frc.team3405.robot.subsystems.Pneumatics
import frc.team3405.robot.subsystems.Reporter
import kotlinx.coroutines.experimental.async
import main.java.frc.team3405.robot.commands.LiftLeftCommand
import main.java.frc.team3405.robot.commands.LiftRightCommand
import org.opencv.imgproc.Imgproc
import org.opencv.core.Mat
import edu.wpi.cscore.CvSource
import edu.wpi.cscore.CvSink
import edu.wpi.cscore.UsbCamera
import kotlinx.coroutines.experimental.launch


class Robot : IterativeRobot() {
    companion object {
        val driveTrain = DriveTrain()
        val pneumatics = Pneumatics()
//        val reporter = Reporter()
        val joystick = XboxController(Joystick(0))
//        val guitar = GuitarController(Joystick(1))
        val conveyor = ConveyorBelt()

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

        Robot.dropWingsButton.whenPressed(DropWingsCommand())

        Robot.liftLeftButton.whenPressed(LiftLeftCommand())
        Robot.dropLeftButton.whenPressed(DropLeftCommand())

        Robot.liftRightButton.whenPressed(LiftRightCommand())
        Robot.dropRightButton.whenPressed(DropRightCommand())


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
