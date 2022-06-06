package labOOP2.shapeInterface

import labOOP2.Colors

interface ColoredShape2d : Shape2d {
    val borderColor: Colors
    val fillColor: Colors
}