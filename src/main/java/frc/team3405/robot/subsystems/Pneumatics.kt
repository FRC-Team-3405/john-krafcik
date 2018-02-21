package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.Compressor
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team3405.robot.Robot
import frc.team3405.robot.commands.ShiftDownCommand
import frc.team3405.robot.commands.ShiftUpCommand


class Pneumatics: Subsystem() {

    val shifter = PneumaticShifter(Compressor(0), DoubleSolenoid(4, 5))

    override fun initDefaultCommand() {
        shifter.enabled()
    }

    fun shiftUp() {
        shifter.shiftUp()
    }

    fun shiftDown() {
        shifter.shiftDown()
    }
}

class PneumaticShifter(val compressor: Compressor, val doubleSolenoid: DoubleSolenoid) {
    var isHighGear = false

    fun enabled() {
        compressor.enabled()
        compressor.closedLoopControl = true
    }

    fun compressorOn() {
        compressor.start()
    }

    fun compressorOff() {
        compressor.stop()
    }

    fun shiftUp() {
        System.out.println("Shift Up")
        if(!isHighGear) {
            doubleSolenoid.set(DoubleSolenoid.Value.kForward)
            isHighGear = true
        }
    }

    fun shiftDown() {
        System.out.println("Shift Down")
        if(isHighGear) {
            doubleSolenoid.set(DoubleSolenoid.Value.kReverse)
            isHighGear = false
        }
    }
}