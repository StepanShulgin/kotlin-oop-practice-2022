package labOOP4.model

import labOOP4.MazeFileWorker
import labOOP4.model.Model.Symbol.Finish
import labOOP4.model.Model.Symbol.Player


interface ModelChangeListener{
     fun onModelChanged()
}

class Model {
    private enum class Symbol(var symbol: String) {
        Player("P"), Finish("E"), Empty("-"), Wall("#")

    }

    enum class Move {
        Left, Right, Up, Down, Stay
    }

    enum class Condition {
        Run, Finish
    }

    var state: Condition

    private var currentVerticalCoordinate: Int
    private var currentHorizontalCoordinate: Int

    private var mazeMatrix: Array<Array<String>>


    init {
        var checkForEnd = 0
        state = Condition.Run
        currentVerticalCoordinate = -1
        currentHorizontalCoordinate = -1
        mazeMatrix = MazeFileWorker.readMaze()

        for (i in mazeMatrix.indices) {
            for (j in 0 until mazeMatrix[i].size) {
                if (mazeMatrix[i][j] == Player.symbol) {

                    currentVerticalCoordinate = i
                    currentHorizontalCoordinate = j
                }
                if (mazeMatrix[i][j] == Finish.symbol) {
                    checkForEnd = 1
                }

            }

        }

        if (currentVerticalCoordinate == -1) throw Exception("No Player in Maze")
        if (checkForEnd == 0) throw Exception("No Finish in Maze")

    }

    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()
    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }


    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    private fun makeCorrectMove(HorizontalCoordinate: Int, VerticalCoordinate: Int, movement: Move) {

        if((HorizontalCoordinate>=0 && HorizontalCoordinate<mazeMatrix.size)&&(VerticalCoordinate>=0 && VerticalCoordinate<mazeMatrix[0].size)) {
            when(movement) {
                Move.Left -> {
                    if (HorizontalCoordinate > 0 && mazeMatrix[VerticalCoordinate][HorizontalCoordinate - 1] != Symbol.Wall.symbol) {

                        mazeMatrix[VerticalCoordinate][HorizontalCoordinate] = Symbol.Empty.symbol
                        mazeMatrix[VerticalCoordinate][HorizontalCoordinate - 1] = Player.symbol
                        currentHorizontalCoordinate--
                    } else throw Exception("Invalid move")
                }
                Move.Right -> {
                    if (HorizontalCoordinate < (mazeMatrix[0].size - 1) && mazeMatrix[VerticalCoordinate][HorizontalCoordinate + 1] != Symbol.Wall.symbol) {
                        mazeMatrix[VerticalCoordinate][HorizontalCoordinate] = Symbol.Empty.symbol
                        mazeMatrix[VerticalCoordinate][HorizontalCoordinate + 1] = Player.symbol
                        currentHorizontalCoordinate--
                    } else throw Exception("Invalid move")

                }
                Move.Up -> {
                    if (VerticalCoordinate < (mazeMatrix[0].size - 1) && mazeMatrix[VerticalCoordinate + 1][HorizontalCoordinate] != Symbol.Wall.symbol) {
                        mazeMatrix[VerticalCoordinate][HorizontalCoordinate] = Symbol.Empty.symbol
                        mazeMatrix[VerticalCoordinate + 1][HorizontalCoordinate] = Player.symbol
                        currentVerticalCoordinate++
                    } else throw Exception("Invalid move")

                }
                Move.Down -> {
                    if (VerticalCoordinate > 0 && mazeMatrix[VerticalCoordinate][HorizontalCoordinate - 1] != Symbol.Wall.symbol) {
                        mazeMatrix[VerticalCoordinate][HorizontalCoordinate] = Symbol.Empty.symbol
                        mazeMatrix[VerticalCoordinate - 1][HorizontalCoordinate] = Player.symbol
                        currentVerticalCoordinate++

                    } else throw Exception("Invalid move")

                }
                Move.Stay -> throw Exception("Do not stay on place")
            }



            if (mazeMatrix[currentVerticalCoordinate][currentHorizontalCoordinate] == Finish.symbol) state = Condition.Finish
        }
        else throw Exception("Invalid move")
    }

    fun makeStep(movement: Move) {

        if (state == Condition.Run) {
            when (movement) {
                Move.Left -> makeCorrectMove(currentHorizontalCoordinate,currentVerticalCoordinate , Move.Left)
                Move.Right -> makeCorrectMove(currentHorizontalCoordinate,currentVerticalCoordinate, Move.Right)
                Move.Up -> makeCorrectMove(currentHorizontalCoordinate,currentVerticalCoordinate , Move.Up)
                Move.Down -> makeCorrectMove(currentHorizontalCoordinate,currentVerticalCoordinate, Move.Down)
                Move.Stay -> makeCorrectMove(currentHorizontalCoordinate,currentVerticalCoordinate , Move.Stay)
            }

        } else throw Exception("Game has already finished")
        notifyListeners()
    }

    fun saveGame() = MazeFileWorker.saveMaze(mazeMatrix)

    fun getMazeMatrix() = mazeMatrix

}




