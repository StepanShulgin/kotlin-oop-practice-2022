package labOOP4

import java.io.File

object MazeFileWorker {
    private const val mazeInput = "C:\\Users\\stepa\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\labOOP4\\Maze.txt"
    private const val mazeSave =
        "C:\\Users\\stepa\\IdeaProjects\\kotlin-oop-practice-2022\\src\\main\\kotlin\\labOOP4\\MazeSave.txt"


    fun readMaze(): Array<Array<String>> {
        val mazeList: List<String> = File(mazeInput).useLines { it.toList() }
        val mazeMatrix = Array(size = (mazeList.size)) { Array((mazeList[0].length)) { "-" } }

        for (i in mazeList.indices) {
            for (j in 0 until mazeList[i].length) {
                mazeMatrix[i][j] = mazeList[i][j].toString()

            }

        }
        return mazeMatrix
    }


    fun saveMaze(mazeMatrix: Array<Array<String>>) {
        File(mazeSave).printWriter().use { out ->
            for (i in mazeMatrix.indices) {
                for (j in 0 until mazeMatrix[i].size) {
                    out.print(mazeMatrix[i][j])
                }
                out.println()

            }
        }


    }


}
