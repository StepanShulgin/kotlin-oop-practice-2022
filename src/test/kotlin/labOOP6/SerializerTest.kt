package labOOP6


import labOOP2.ShapeCollector
import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


enum class ResultString(var text: String) {
    Serial("[{\"type\":\"labOOP2.shapes.Circle\",\"radius\":25.0,\"borderColor\":{\"red\":184.0,\"green\":50.0,\"blue\":139.0,\"opacity\":1.0},\"fillColor\":{\"red\":0.0,\"green\":255.0,\"blue\":0.0,\"opacity\":1.0}},{\"type\":\"labOOP2.shapes.Triangle\",\"aSide\":5.0,\"bSide\":5.0,\"cSide\":5.0,\"borderColor\":{\"red\":0.0,\"green\":0.0,\"blue\":255.0,\"opacity\":1.0},\"fillColor\":{\"red\":0.0,\"green\":255.0,\"blue\":0.0,\"opacity\":1.0}},{\"type\":\"labOOP2.shapes.Rectangle\",\"rSide\":5.0,\"lSide\":10.0,\"borderColor\":{\"red\":0.0,\"green\":255.0,\"blue\":0.0,\"opacity\":1.0},\"fillColor\":{\"red\":184.0,\"green\":50.0,\"blue\":139.0,\"opacity\":1.0}},{\"type\":\"labOOP2.shapes.Square\",\"side\":5.0,\"borderColor\":{\"red\":184.0,\"green\":50.0,\"blue\":139.0,\"opacity\":1.0},\"fillColor\":{\"red\":0.0,\"green\":255.0,\"blue\":0.0,\"opacity\":1.0}}]")


}

internal class SerializerTest {
    @Test
    fun doSerializationTest() {

        val circle = Circle(25.0, labOOP2.SetColor.Pink.color, labOOP2.SetColor.Green.color)
        val triangle = Triangle(5.0, 5.0, 5.0, labOOP2.SetColor.Blue.color, labOOP2.SetColor.Green.color)
        val rectangle = Rectangle(5.0, 10.0, labOOP2.SetColor.Green.color, labOOP2.SetColor.Pink.color)
        val square = Square(5.0, labOOP2.SetColor.Pink.color, labOOP2.SetColor.Green.color)

        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(Serializer.doSerialization(shapeList.getListOfShapes()), ResultString.Serial.text)

    }

    @Test
    fun doDeserialization() {
        val circle = Circle(25.0, labOOP2.SetColor.Pink.color, labOOP2.SetColor.Green.color)
        val triangle = Triangle(5.0, 5.0, 5.0, labOOP2.SetColor.Blue.color, labOOP2.SetColor.Green.color)
        val rectangle = Rectangle(5.0, 10.0, labOOP2.SetColor.Green.color, labOOP2.SetColor.Pink.color)
        val square = Square(5.0, labOOP2.SetColor.Pink.color, labOOP2.SetColor.Green.color)

        val shapeList = ShapeCollector(listOf(circle, triangle, rectangle, square))
        assertEquals(
            Serializer.doDeserialization(ResultString.Serial.text).toString(),
            shapeList.getListOfShapes().toString()
        )

    }

}