package frc.team3405.robot

import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton

object Xbox {
    const val AButton = 1
    const val BButton = 2
    const val XButton = 3
    const val YButton = 4
    const val LeftBumper = 5
    const val RightBumper = 6
    const val BackButton = 7
    const val StartButton = 8
    const val LeftJoystickButton = 9
    const val RightJoystickButton = 10
    const val LeftX = 0
    const val LeftY = 1
    const val LeftTrigger = 2
    const val RightTrigger = 3
    const val RightX = 4
    const val RightY = 5
}


class XboxController(val joystick: Joystick) {
    val rightX
        get() = joystick.getRawAxis(Xbox.RightX)

    val rightY
        get() = joystick.getRawAxis(Xbox.RightY)

    val leftX
        get() = joystick.getRawAxis(Xbox.LeftX)

    val leftY
        get() = joystick.getRawAxis(Xbox.LeftY)
}
