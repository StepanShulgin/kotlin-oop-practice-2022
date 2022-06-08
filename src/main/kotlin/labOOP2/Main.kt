//I did it immediately for sterilization and the use of Generics

package labOOP2

import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle

enum class SetColor(var color: Colors) {
    Green(Colors(0.0, 255.0, 0.0, 1.0)),
    Blue(Colors(0.0, 0.0, 255.0, 1.0)),
    Pink(Colors(184.0, 50.0, 139.0, 1.0))

}

fun main() {

    val circle = Circle(25.0, SetColor.Pink.color, SetColor.Green.color)
    val triangle = Triangle(5.0, 5.0, 5.0, SetColor.Blue.color, SetColor.Green.color)
    val rectangle = Rectangle(5.0, 10.0, SetColor.Green.color, SetColor.Pink.color)
    val square = Square(5.0, SetColor.Pink.color, SetColor.Green.color)
    val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))


    println("All shapes: ${shapeList.getListOfShapes()}")
    println("Only circles : ${shapeList.getByType(Circle::class.java)}")
    println("Collection's size: ${shapeList.getListOfShapesSize()}")

    //Verification of all methods of ShapeCollector is presented in the tests


}

