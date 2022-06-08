package labOOP4.view

import labOOP4.model.Model
import labOOP4.model.ModelChangeListener


class ConsoleUI(private val mazeModel: Model) {

    init {
        val listener = object : ModelChangeListener {
            override fun onModelChanged() {
                repaint()
            }
        }
        mazeModel.addModelChangeListener(listener)
        repaint()
    }
    fun repaint(){
        val mazeMatrix = mazeModel.getMazeMatrix()
        for (i in mazeMatrix.indices) {
            for (j in 0 until mazeMatrix[i].size) {
                print(mazeMatrix[i][j])
            }
            println()
        }
    }

}

