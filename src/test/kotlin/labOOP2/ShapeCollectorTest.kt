package labOOP2

import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

enum class SetColor(var scolor: Colors){
    GREEN( Colors(0.0, 255.0, 0.0, 1.0)),
    BLUE( Colors(0.0, 0.0, 255.0, 1.0)),
    PINK( Colors( 184.0, 50.0, 139.0,1.0))

}

internal class ShapeCollectorTest {

    val circle = Circle(25.0, SetColor.PINK.scolor, SetColor.GREEN.scolor)
    val triangle = Triangle(5.0, 5.0, 5.0, SetColor.BLUE.scolor, SetColor.GREEN.scolor)
    val rectangle = Rectangle(5.0, 10.0, SetColor.GREEN.scolor, SetColor.PINK.scolor)
    val square = Square(5.0, SetColor.PINK.scolor, SetColor.GREEN.scolor)

    @Test
    fun addNewShape() {
        val shapeCollection = ShapeCollector(listOf(circle, triangle, rectangle))
        assertEquals(listOf(circle, triangle, rectangle), shapeCollection.getListOfShapes())
        shapeCollection.addNewShape(square)
        assertEquals(listOf(circle, triangle, rectangle, square), shapeCollection.getListOfShapes())
    }

    @Test
    fun minAreaSearcher() {
        val shapeCollection = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(triangle), shapeCollection.minAreaSearcher())
    }

    @Test
    fun maxAreaSearcher() {
        val shapeCollection = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(circle), shapeCollection.maxAreaSearcher())
    }

    @Test
    fun wholeSumm() {
        val shapeCollection = ShapeCollector(listOf(rectangle, square))
        assertEquals(75.0, shapeCollection.wholeSumm())
    }

    @Test
    fun borderColorSearcher() {
        val shapeCollection = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(circle, square), shapeCollection.borderColorSearcher(SetColor.PINK.scolor))

    }

    @Test
    fun fillColorFilter() {
        val shapeCollection = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(rectangle), shapeCollection.fillColorSearcher(SetColor.PINK.scolor))
    }

    @Test
    fun getListOfShapes() {
        val shapeCollection = ShapeCollector(listOf(rectangle, square))
        assertEquals(listOf(rectangle, square), shapeCollection.getListOfShapes())
    }


    @Test
    fun groupByBorderColor() {
        val testShapeCollection = ShapeCollector(listOf(circle, square))
        val testMap = mutableMapOf(
            SetColor.PINK.scolor to listOf(circle, square),
        )
        assertEquals(testMap.toString(), testShapeCollection.groupByBorderColor().toString())
    }

    @Test
    fun groupByFillColor() {
        val testShapeCollection = ShapeCollector(listOf(circle, triangle, square))
        val testMap = mutableMapOf(
            SetColor.GREEN.scolor to listOf(circle, triangle, square),
        )
        assertEquals(testMap.toString(), testShapeCollection.groupByFillColor().toString())
    }

    @Test
    fun getByType() {
        val shapeCollection = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(listOf(circle), shapeCollection.getByType(Circle::class.java))
    }

}

