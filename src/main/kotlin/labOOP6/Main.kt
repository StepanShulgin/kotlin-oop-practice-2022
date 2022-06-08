@file:Suppress("UNCHECKED_CAST")

package labOOP6

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
    val secondCircle = Circle(25.0, labOOP2.SetColor.Green.color, labOOP2.SetColor.Blue.color)
    val secondTriangle = Triangle(5.0, 5.0, 5.0, labOOP2.SetColor.Green.color, labOOP2.SetColor.Blue.color)
    val secondRectangle = Rectangle(5.0, 10.0, labOOP2.SetColor.Pink.color, labOOP2.SetColor.Blue.color)
    val secondSquare = Square(5.0, labOOP2.SetColor.Blue.color, labOOP2.SetColor.Pink.color)
    var shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))

    Serializer.doSerializationFile(shapeList.getListOfShapes(), "file1.txt")
    shapeList = ShapeCollector(Serializer.doDeserializationFile("file1.txt"))
    println("Shapes: ${shapeList.getListOfShapes()}")
    shapeList.addNewShape(secondCircle)
    shapeList.addNewShape(secondTriangle)
    shapeList.addNewShape(secondRectangle)
    shapeList.addNewShape(secondSquare)
    Serializer.doSerializationFile(shapeList.getListOfShapes(), "file2.txt")
}