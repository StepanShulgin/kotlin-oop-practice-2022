package labOOP5

import labOOP2.SetColor
import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle
import labOOP2.ShapeCollector
import labOOP5.Comporators.ComparatorOfArea

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeCollectorTest {

    @Test
    fun getWholeList() {

        val circle = Circle(25.0, SetColor.PINK.scolor, SetColor.GREEN.scolor)
        val triangle = Triangle(5.0, 5.0, 5.0, SetColor.BLUE.scolor, SetColor.GREEN.scolor)
        val rectangle = Rectangle(5.0, 10.0, SetColor.GREEN.scolor, SetColor.PINK.scolor)
        val square = Square(5.0, SetColor.PINK.scolor, SetColor.GREEN.scolor)


        val shapeCollection = ShapeCollector(listOf(circle, triangle,rectangle,square))
        val TestshapeCollection = ShapeCollector(listOf())
        TestshapeCollection.getWholeList(shapeCollection.getListOfShapes())

        assertEquals(shapeCollection.getListOfShapes(), TestshapeCollection.getListOfShapes())


    }

    @Test
    fun getSorted() {


        val circle = Circle(25.0, SetColor.PINK.scolor, SetColor.GREEN.scolor)
        val triangle = Triangle(5.0, 5.0, 5.0, SetColor.BLUE.scolor, SetColor.GREEN.scolor)
        val rectangle = Rectangle(5.0, 10.0, SetColor.GREEN.scolor, SetColor.PINK.scolor)
        val square = Square(5.0, SetColor.PINK.scolor, SetColor.GREEN.scolor)

        val shapeCollection = ShapeCollector(listOf(circle, triangle,rectangle,square))
        shapeCollection.sort(ComparatorOfArea())

        assertEquals(listOf(triangle, square, rectangle, circle), shapeCollection.getListOfShapes())
    }


}