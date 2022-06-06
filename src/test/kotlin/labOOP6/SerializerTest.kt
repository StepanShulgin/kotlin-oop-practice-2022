package labOOP6


import labOOP2.ShapeCollector
import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


enum class SeOrDeserString(var text:String){
    serial("[{\"type\":\"labOOP2.shapes.Circle\",\"radius\":25.0,\"borderColor\":{\"RED\":184.0,\"GREEN\":50.0,\"BLUE\":139.0,\"OPACIRY\":1.0},\"fillColor\":{\"RED\":0.0,\"GREEN\":255.0,\"BLUE\":0.0,\"OPACIRY\":1.0}},{\"type\":\"labOOP2.shapes.Triangle\",\"aSide\":5.0,\"bSide\":5.0,\"cSide\":5.0,\"borderColor\":{\"RED\":0.0,\"GREEN\":0.0,\"BLUE\":255.0,\"OPACIRY\":1.0},\"fillColor\":{\"RED\":0.0,\"GREEN\":255.0,\"BLUE\":0.0,\"OPACIRY\":1.0}},{\"type\":\"labOOP2.shapes.Rectangle\",\"rSide\":5.0,\"lSide\":10.0,\"borderColor\":{\"RED\":0.0,\"GREEN\":255.0,\"BLUE\":0.0,\"OPACIRY\":1.0},\"fillColor\":{\"RED\":184.0,\"GREEN\":50.0,\"BLUE\":139.0,\"OPACIRY\":1.0}},{\"type\":\"labOOP2.shapes.Square\",\"side\":5.0,\"borderColor\":{\"RED\":184.0,\"GREEN\":50.0,\"BLUE\":139.0,\"OPACIRY\":1.0},\"fillColor\":{\"RED\":0.0,\"GREEN\":255.0,\"BLUE\":0.0,\"OPACIRY\":1.0}}]")


}

internal class SerializerTest
{
    @Test
    fun doSerializationTest(){

        val circle = Circle(25.0, labOOP2.SetColor.PINK.scolor, labOOP2.SetColor.GREEN.scolor)
        val triangle = Triangle(5.0, 5.0, 5.0, labOOP2.SetColor.BLUE.scolor, labOOP2.SetColor.GREEN.scolor)
        val rectangle = Rectangle(5.0, 10.0, labOOP2.SetColor.GREEN.scolor, labOOP2.SetColor.PINK.scolor)
        val square = Square(5.0, labOOP2.SetColor.PINK.scolor, labOOP2.SetColor.GREEN.scolor)

        val shapeCollector = ShapeCollector(listOf(circle, triangle,rectangle,square))
        assertEquals(Serializer.doSerialization(shapeCollector.getListOfShapes()),SeOrDeserString.serial.text)

    }
    @Test
    fun doDeserialization(){
        val circle = Circle(25.0, labOOP2.SetColor.PINK.scolor, labOOP2.SetColor.GREEN.scolor)
        val triangle = Triangle(5.0, 5.0, 5.0, labOOP2.SetColor.BLUE.scolor, labOOP2.SetColor.GREEN.scolor)
        val rectangle = Rectangle(5.0, 10.0, labOOP2.SetColor.GREEN.scolor, labOOP2.SetColor.PINK.scolor)
        val square = Square(5.0, labOOP2.SetColor.PINK.scolor, labOOP2.SetColor.GREEN.scolor)

        val shapeCollector = ShapeCollector(listOf(circle, triangle,rectangle,square))
        assertEquals(Serializer.doDeserialization(SeOrDeserString.serial.text).toString(),shapeCollector.getListOfShapes().toString())

    }

}