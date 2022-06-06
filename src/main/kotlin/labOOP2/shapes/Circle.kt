package labOOP2.shapes

import kotlinx.serialization.Serializable
import labOOP2.ErrList
import labOOP2.shapeInterface.ColoredShape2d
import labOOP2.Colors
import kotlin.math.PI


@Serializable
class Circle(val radius: Double, override val borderColor: Colors,
             override val fillColor: Colors,
) : ColoredShape2d {

    override val area: Double  get() = PI * radius * radius

    init {
        if (radius <= 0)
        {
            throw IllegalArgumentException(ErrList.RadErr.erroR)
        }
    }

    override fun toString(): String {

        val returnString = "[Radius: $radius;Fill Color: $fillColor; Border Color: $borderColor; Area: $area]"

        return returnString
    }

}