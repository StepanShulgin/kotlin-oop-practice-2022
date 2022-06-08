package labOOP2.shapes

import kotlinx.serialization.Serializable
import labOOP2.Colors
import labOOP2.ErrorList
import labOOP2.shapeInterface.ColoredShape2d
import kotlin.math.PI


@Serializable
class Circle(
    private val radius: Double, override val borderColor: Colors,
    override val fillColor: Colors,
) : ColoredShape2d {

    override val area: Double get() = PI * radius * radius

    init {
        if (radius <= 0) {
            throw IllegalArgumentException(ErrorList.RadiusError.error)
        }
    }

    override fun toString(): String {
        return "[Radius: $radius;Fill Color: $fillColor; Border Color: $borderColor; Area: $area]"
    }

}