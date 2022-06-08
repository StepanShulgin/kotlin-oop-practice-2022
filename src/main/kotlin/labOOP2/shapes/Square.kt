package labOOP2.shapes

import kotlinx.serialization.Serializable
import labOOP2.Colors
import labOOP2.ErrorList
import labOOP2.shapeInterface.ColoredShape2d

@Serializable
data class Square(val side: Double, override val borderColor: Colors, override val fillColor: Colors) : ColoredShape2d {

    override val area: Double
        get() = side * side

    init {
        if (side < 0) {
            throw IllegalArgumentException(ErrorList.SideErr.error)
        }
    }

    override fun toString(): String {

        return "[Side: $side; Fill Color: $fillColor; Border Color: $borderColor;  Area: $area]"
    }

}