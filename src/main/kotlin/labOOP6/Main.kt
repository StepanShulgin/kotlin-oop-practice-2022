@file:Suppress("UNCHECKED_CAST")
package labOOP6

import labOOP2.ShapeCollector
import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle



fun main() {


    val circle = Circle(25.0, labOOP2.SetColor.PINK.scolor, labOOP2.SetColor.GREEN.scolor)
    val triangle = Triangle(5.0, 5.0, 5.0, labOOP2.SetColor.BLUE.scolor, labOOP2.SetColor.GREEN.scolor)
    val rectangle = Rectangle(5.0, 10.0, labOOP2.SetColor.GREEN.scolor, labOOP2.SetColor.PINK.scolor)
    val square = Square(5.0, labOOP2.SetColor.PINK.scolor, labOOP2.SetColor.GREEN.scolor)
    val secondcircle = Circle(25.0, labOOP2.SetColor.GREEN.scolor, labOOP2.SetColor.BLUE.scolor)
    val secondtriangle = Triangle(5.0, 5.0, 5.0, labOOP2.SetColor.GREEN.scolor, labOOP2.SetColor.BLUE.scolor)
    val secondrectangle = Rectangle(5.0, 10.0, labOOP2.SetColor.PINK.scolor, labOOP2.SetColor.BLUE.scolor)
    val secondsquare = Square(5.0, labOOP2.SetColor.BLUE.scolor, labOOP2.SetColor.PINK.scolor)
    var shapeCollection = ShapeCollector(listOf(circle, triangle, rectangle, square))

    Serializer.doSerializationFile(shapeCollection.getListOfShapes(), "file1.txt")
    shapeCollection = ShapeCollector(Serializer.doDeserializationFile("file1.txt"))
    println("Shapes read from file: ${shapeCollection.getListOfShapes()}")
    shapeCollection.addNewShape(secondcircle)
    shapeCollection.addNewShape(secondtriangle)
    shapeCollection.addNewShape(secondrectangle)
    shapeCollection.addNewShape(secondsquare)
    Serializer.doSerializationFile(shapeCollection.getListOfShapes(), "file2.txt")
}