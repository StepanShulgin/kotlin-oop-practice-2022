package labOOP2.shapes

import kotlinx.serialization.Serializable
import labOOP2.Colors
import labOOP2.ErrorList
import labOOP2.shapeInterface.ColoredShape2d
import kotlin.math.sqrt

@Serializable
data class Triangle(
    val aSide: Double,
    val bSide: Double,
    val cSide: Double,
    override val borderColor: Colors,
    override val fillColor: Colors
) :
    ColoredShape2d {

    override val area: Double
        get() {
            return sqrt(((aSide + bSide + cSide) / 2) * (((aSide + bSide + cSide) / 2) - aSide) * (((aSide + bSide + cSide) / 2) - bSide) * (((aSide + bSide + cSide) / 2) - cSide))
        }

    init {
        if (aSide < 0 || bSide < 0 || cSide < 0 || aSide + bSide < cSide || bSide + cSide < aSide || aSide + cSide < bSide) {
            throw IllegalArgumentException(ErrorList.SideErr.error)
        }
    }

    override fun toString(): String {

        return "[Side A: $aSide, Side B: $bSide, Side C:$cSide; Fill Color: $fillColor; Border Color: $borderColor;  Area: $area]"
    }

}