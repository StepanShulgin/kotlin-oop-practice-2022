package labOOP5

import labOOP2.SetColor
import labOOP2.ShapeCollector
import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShapeCollectorTest {

    @Test
    fun getWholeList() {

        val circle = Circle(25.0, SetColor.Pink.color, SetColor.Green.color)
        val triangle = Triangle(5.0, 5.0, 5.0, SetColor.Blue.color, SetColor.Green.color)
        val rectangle = Rectangle(5.0, 10.0, SetColor.Green.color, SetColor.Pink.color)
        val square = Square(5.0, SetColor.Pink.color, SetColor.Green.color)


        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
        val secondShapeList = ShapeCollector(listOf())
        secondShapeList.getWholeList(shapeList.getListOfShapes())
        assertEquals(shapeList.getListOfShapes(), secondShapeList.getListOfShapes())


    }

    @Test
    fun getSorted() {

        val circle = Circle(25.0, SetColor.Pink.color, SetColor.Green.color)
        val triangle = Triangle(5.0, 5.0, 5.0, SetColor.Blue.color, SetColor.Green.color)
        val rectangle = Rectangle(5.0, 10.0, SetColor.Green.color, SetColor.Pink.color)
        val square = Square(5.0, SetColor.Pink.color, SetColor.Green.color)

        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
        shapeList.sort(ComparatorOfArea())

        assertEquals(listOf(triangle, square, rectangle, circle), shapeList.getListOfShapes())
    }


}