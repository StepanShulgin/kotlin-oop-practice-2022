package labOOP2.shapes

import kotlinx.serialization.Serializable
import labOOP2.ErrList
import labOOP2.shapeInterface.ColoredShape2d
import labOOP2.Colors



@Serializable
data class Rectangle(val rSide: Double, val lSide: Double, override val borderColor: Colors, override val fillColor: Colors) :
    ColoredShape2d {

    override val area: Double
        get() = rSide * lSide

    init {
        if (rSide < 0 || lSide < 0)
        {
            throw IllegalArgumentException(ErrList.SideErr.erroR)
        }
    }

    override fun toString(): String
    {
        val sideStr = "[One side: $rSide, Second side: $lSide; Fill Color: $fillColor; Border Color: $borderColor;  Area: $area]"
        return sideStr
    }

}