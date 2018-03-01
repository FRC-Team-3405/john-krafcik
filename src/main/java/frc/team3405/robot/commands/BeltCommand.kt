package frc.team3405.robot.commands

class BeltCommand: Command() {
    init {
        requires(Robot.conveyor)
    }

    override fun execute() {
        Robot.conveyor.moveBelt()
    }

    override fun isFinished(): Boolean = false
}