package labOOP5


import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle
import labOOP2.ShapeCollector
import labOOP5.Comporators.ComparatorOfArea



fun main() {
    val circle = Circle(25.0, labOOP2.SetColor.PINK.scolor, labOOP2.SetColor.GREEN.scolor)
    val triangle = Triangle(5.0, 5.0, 5.0, labOOP2.SetColor.BLUE.scolor, labOOP2.SetColor.GREEN.scolor)
    val rectangle = Rectangle(5.0, 10.0, labOOP2.SetColor.GREEN.scolor, labOOP2.SetColor.PINK.scolor)
    val square = Square(5.0, labOOP2.SetColor.PINK.scolor, labOOP2.SetColor.GREEN.scolor)
    val shapeCollection = ShapeCollector(listOf(circle, triangle, rectangle,square))
    println("Sorted by area: ${shapeCollection.sort(ComparatorOfArea())}")
}

