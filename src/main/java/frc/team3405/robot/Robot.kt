package frc.team3405.robot

import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team3405.robot.subsystems.DriveTrain

class Robot : IterativeRobot() {
    companion object {
        val driveTrain = DriveTrain()
        val joystick = XboxController(Joystick(0))
    }

    override fun robotInit() {
        println("HI")
    }

    override fun disabledInit() {}

    override fun autonomousInit() {}

    override fun teleopInit() {
        println("I started")
    }

    override fun testInit() {}


    override fun disabledPeriodic() {}

    override fun autonomousPeriodic() {}

    override fun teleopPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun testPeriodic() {}
}