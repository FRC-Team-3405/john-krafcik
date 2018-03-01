package frc.team3405.robot.subsystems

import edu.wpi.first.wpilibj.Compressor
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem


class Pneumatics: Subsystem() {

    val compressor = Compressor(0)

    val shifter = PneumaticShifter(compressor, DoubleSolenoid(4, 5))
    val leftPneumatic = PneumaticShifter(compressor, DoubleSolenoid(0, 1)) //TODO get channels
    val rightPneumatic = PneumaticShifter(compressor, DoubleSolenoid(2, 3))

    override fun initDefaultCommand() {
        shifter.enabled()
        leftPneumatic.enabled()
        rightPneumatic.enabled()
    }

    fun shiftUp() {
        shifter.shiftUp()
    }

    fun shiftDown() {
        shifter.shiftDown()
    }

    fun liftLeft() {
        leftPneumatic.shiftUp()
    }

    fun dropLeft() {
        leftPneumatic.shiftDown()
    }

    fun liftRight() {
        rightPneumatic.shiftUp()
    }

    fun dropRight() {
        rightPneumatic.shiftDown()
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
        println("Shift Up")
        if(!isHighGear) {
            doubleSolenoid.set(DoubleSolenoid.Value.kForward)
            isHighGear = true
        }
    }

    fun shiftDown() {
        println("Shift Down")
        if(isHighGear) {
            doubleSolenoid.set(DoubleSolenoid.Value.kReverse)
            isHighGear = false
        }
    }
}