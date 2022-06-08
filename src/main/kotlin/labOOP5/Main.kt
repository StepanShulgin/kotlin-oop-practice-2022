package labOOP5


import labOOP2.ShapeCollector
import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle


fun main() {
    val circle = Circle(25.0, labOOP2.SetColor.Pink.color, labOOP2.SetColor.Green.color)
    val triangle = Triangle(5.0, 5.0, 5.0, labOOP2.SetColor.Blue.color, labOOP2.SetColor.Green.color)
    val rectangle = Rectangle(5.0, 10.0, labOOP2.SetColor.Green.color, labOOP2.SetColor.Pink.color)
    val square = Square(5.0, labOOP2.SetColor.Pink.color, labOOP2.SetColor.Green.color)
    val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
    println("Sorted by area: ${shapeList.sort(ComparatorOfArea())}")
}

