package frc.team3405.robot

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import edu.wpi.first.wpilibj.command.Command
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team3405.robot.commands.AutonomousCommand
import frc.team3405.robot.commands.ShiftDownCommand
import frc.team3405.robot.commands.ShiftUpCommand
import frc.team3405.robot.subsystems.ConveyorBelt
import frc.team3405.robot.subsystems.DriveTrain
import frc.team3405.robot.subsystems.Pneumatics
import frc.team3405.robot.subsystems.Reporter

class Robot : IterativeRobot() {
    companion object {
        val driveTrain = DriveTrain()
        val pneumatics = Pneumatics()
        val reporter = Reporter()
        val joystick = XboxController(Joystick(0))
        val guitar = GuitarController(Joystick(1))
        val conveyor = ConveyorBelt()

        //Gear shifting buttons
        val highGearButton = JoystickButton(joystick.joystick, Xbox.RightBumper)
        val lowGearButton = JoystickButton(joystick.joystick, Xbox.LeftBumper)
    }

    lateinit var autonomousCommand: Command

    override fun robotInit() {
        println("HI")
        Robot.highGearButton.whenPressed(ShiftUpCommand())
        Robot.lowGearButton.whenPressed(ShiftDownCommand())
        println("Button presses ready")
    }

    override fun disabledInit() {}

    override fun autonomousInit() {
        autonomousCommand = AutonomousCommand()
        autonomousCommand.start()
    }

    override fun teleopInit() {
        println("I started")
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