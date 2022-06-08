package labOOP2

import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShapeCollectorTest {

    private val circle = Circle(25.0, SetColor.Pink.color, SetColor.Green.color)
    private val triangle = Triangle(5.0, 5.0, 5.0, SetColor.Blue.color, SetColor.Green.color)
    private val rectangle = Rectangle(5.0, 10.0, SetColor.Green.color, SetColor.Pink.color)
    private val square = Square(5.0, SetColor.Pink.color, SetColor.Green.color)

    @Test
    fun addNewShape() {
        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle))
        assertEquals(listOf(circle, triangle, rectangle), shapeList.getListOfShapes())
        shapeList.addNewShape(square)
        assertEquals(listOf(circle, triangle, rectangle, square), shapeList.getListOfShapes())
    }

    @Test
    fun searchMinArea() {
        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(triangle), shapeList.searchMinArea())
    }

    @Test
    fun searchMaxArea() {
        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(circle), shapeList.searchMaxArea())
    }

    @Test
    fun getWholeSum() {
        val shapeList = ShapeCollector(listOf(rectangle, square))
        assertEquals(75.0, shapeList.getWholeSum())
    }

    @Test
    fun searchBorderColor() {
        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(circle, square), shapeList.searchBorderColor(SetColor.Pink.color))

    }

    @Test
    fun fillColorFilter() {
        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(rectangle), shapeList.fillColorSearcher(SetColor.Pink.color))
    }

    @Test
    fun getListOfShapes() {
        val shapeList = ShapeCollector(listOf(rectangle, square))
        assertEquals(listOf(rectangle, square), shapeList.getListOfShapes())
    }


    @Test
    fun groupByBorderColor() {
        val shapeList = ShapeCollector(listOf(circle, square))
        val testMap = mutableMapOf(
            SetColor.Pink.color to listOf(circle, square),
        )
        assertEquals(testMap.toString(), shapeList.groupByBorderColor().toString())
    }

    @Test
    fun groupByFillColor() {
        val shapeList = ShapeCollector(listOf(circle, triangle, square))
        val testMap = mutableMapOf(
            SetColor.Green.color to listOf(circle, triangle, square),
        )
        assertEquals(testMap.toString(), shapeList.groupByFillColor().toString())
    }

    @Test
    fun getByType() {
        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(circle), shapeList.getByType(Circle::class.java))
    }

}

