package labOOP2.shapes

import kotlinx.serialization.Serializable
import labOOP2.Colors
import labOOP2.ErrorList
import labOOP2.shapeInterface.ColoredShape2d


@Serializable
data class Rectangle(
    val rSide: Double, val lSide: Double, override val borderColor: Colors, override val fillColor: Colors
) : ColoredShape2d {

    override val area: Double
        get() = rSide * lSide

    init {
        if (rSide < 0 || lSide < 0) {
            throw IllegalArgumentException(ErrorList.SideErr.error)
        }
    }

    override fun toString(): String {
        return "[One side: $rSide, Second side: $lSide; Fill Color: $fillColor; Border Color: $borderColor;  Area: $area]"
    }

}