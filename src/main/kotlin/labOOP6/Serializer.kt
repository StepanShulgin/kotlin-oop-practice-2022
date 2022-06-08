package labOOP6

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import labOOP2.shapeInterface.ColoredShape2d
import labOOP2.shapes.Circle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square
import labOOP2.shapes.Triangle
import java.io.File


object Serializer {
    private val json = Json {

        serializersModule = SerializersModule {
            polymorphic(ColoredShape2d::class) {
                subclass(Circle::class)
                subclass(Triangle::class)
                subclass(Rectangle::class)
                subclass(Square::class)
            }
        }
    }

    fun doSerialization(shapeList: List<ColoredShape2d>) =
        json.encodeToString(shapeList)

    fun doDeserialization(stringToDecoder: String) =
        json.decodeFromString<List<ColoredShape2d>>(stringToDecoder)


    //For files and demonstration of serialization and deserialization

    fun doSerializationFile(shapeList: List<ColoredShape2d>, fileName: String) {
        File(fileName).writeText(doSerialization(shapeList))
    }

    fun doDeserializationFile(fileName: String): List<ColoredShape2d> {
        val file = File(fileName)
        if (!file.exists())
            throw IllegalArgumentException("Incorrect file name")

        return doDeserialization(file.readText())
    }


}