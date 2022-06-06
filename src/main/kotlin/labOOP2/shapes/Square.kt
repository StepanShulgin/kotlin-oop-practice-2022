package labOOP2.shapes

import labOOP2.ErrList
import kotlinx.serialization.Serializable
import labOOP2.shapeInterface.ColoredShape2d
import labOOP2.Colors

@Serializable
data class Square(val side: Double, override val borderColor: Colors, override val fillColor: Colors) : ColoredShape2d {

    override val area: Double
        get() = side * side

    init {
        if (side < 0) {
            throw IllegalArgumentException(ErrList.SideErr.erroR)
        }
    }

    override fun toString(): String {

        val sideret = "[Side: $side; Fill Color: $fillColor; Border Color: $borderColor;  Area: $area]"

        return sideret
    }

}