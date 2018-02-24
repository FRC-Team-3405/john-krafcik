package frc.team3405.robot.commands

import edu.wpi.first.wpilibj.command.Command
import frc.team3405.robot.Robot

class ReportCommand: Command() {
    init {
        requires(Robot.reporter)
    }
    override fun isFinished() = false

    override fun execute() {
        Robot.reporter.report()
    }
}