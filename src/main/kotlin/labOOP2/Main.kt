
//I did it immediately for sterilization and the use of Generics

package labOOP2

import labOOP2.shapes.Circle
import labOOP2.shapes.Triangle
import labOOP2.shapes.Rectangle
import labOOP2.shapes.Square

enum class SetColor(var scolor: Colors){
    GREEN( Colors(0.0, 255.0, 0.0, 1.0)),
    BLUE( Colors(0.0, 0.0, 255.0, 1.0)),
    PINK( Colors( 184.0, 50.0, 139.0,1.0))

}
fun main() {

    val circle = Circle(25.0, SetColor.PINK.scolor, SetColor.GREEN.scolor)
    val triangle = Triangle(5.0, 5.0, 5.0, SetColor.BLUE.scolor, SetColor.GREEN.scolor)
    val rectangle = Rectangle(5.0, 10.0, SetColor.GREEN.scolor, SetColor.PINK.scolor)
    val square = Square(5.0, SetColor.PINK.scolor, SetColor.GREEN.scolor)
    val shapeCollection = ShapeCollector(listOf(circle, triangle, rectangle,square))



    println("Shapes groped by type: ${shapeCollection.getByType(Circle::class.java)}")
    println("Collection's size: ${shapeCollection.getListOfShapesSize()}")

    //Verification of all methods of ShapeCollector is presented in the tests





}

