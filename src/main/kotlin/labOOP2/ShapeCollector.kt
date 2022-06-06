package labOOP2


import labOOP2.shapeInterface.ColoredShape2d

class ShapeCollector<T: ColoredShape2d>(_listOfShapes: List<T>) {
    private val shapeList: MutableList<T>

    init {
        shapeList = _listOfShapes.toMutableList()
    }

    fun addNewShape(newShape: T) = shapeList.add(newShape)

    fun minAreaSearcher(): List<T> {
        if (shapeList.isEmpty())
        {
            return emptyList()
        }
        val minArea = shapeList.minOf{ it.area }
        return shapeList.filter { it.area == minArea }
    }

    fun maxAreaSearcher(): List<T> {
        if (shapeList.isEmpty())
        {
            return emptyList()
        }
        val maxArea = shapeList.maxOf { it.area }
        return shapeList.filter { it.area == maxArea }

    }

    fun wholeSumm(): Double {
        var wholeSum = 0.0
        for (shape in shapeList)
        {
            wholeSum += shape.area
        }
        return  wholeSum
    }

    fun borderColorSearcher(border: Colors): List<T> = shapeList.filter { it.borderColor == border }

    fun fillColorSearcher(fillColor: Colors): List<T> =shapeList.filter { it.fillColor == fillColor }

    fun getListOfShapes(): List<T> = shapeList.toList()

    fun getListOfShapesSize(): Int = shapeList.size

    fun groupByBorderColor(): Map<Colors, List<T>> = shapeList.groupBy { it.borderColor }

    fun groupByFillColor(): Map<Colors, List<T>> = shapeList.groupBy { it.fillColor }

    fun getByType(variable: Class<out T>): List<T> = shapeList.filterIsInstance(variable)




    fun getWholeList(totalList: List<T>) {//Is Not Needed is 2 lab
        totalList.forEach {
            shapeList.add(it)
        }
    }


    fun sort(equelIndentificator: Comparator<in T>): List<T> {//Is Not Needed is 2 lab

        val sortedList = shapeList

        sortedList.sortWith(equelIndentificator)

        return sortedList.toList()

    }
}