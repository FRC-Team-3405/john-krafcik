package frc.team3405.robot

import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton

object Guitar {
    //Button
    const val greenButton = 2
    const val redButton = 3
    const val yellowButton = 1
    const val blueButton = 4
    const val orangeButton = 5

    const val longButton = 9

    const val powerButton = 13

    //Axis
    const val WhammieBar = 2

    //POV
    const val TiltBar = 0
}


class GuitarController(val joystick: Joystick) {
    val whammieBar
        get() = joystick.getRawAxis(Guitar.WhammieBar)

    val tiltBar
        get() = joystick.getPOV(Guitar.TiltBar)
}
