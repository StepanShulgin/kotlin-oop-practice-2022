package labOOP5.Comporators


import labOOP2.shapeInterface.ColoredShape2d
import java.util.Comparator

class ComparatorOfArea : Comparator<ColoredShape2d> {
    override fun compare(a: ColoredShape2d, b: ColoredShape2d): Int {
         if (a.area == b.area) return 0

        else{
             if (a.area > b.area) return 1
             else return -1

        }
    }
}




