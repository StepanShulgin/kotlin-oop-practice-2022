package labOOP4.controller


import labOOP4.model.Model

class Controller(private val model: Model) {
    init {
        play()
    }


    private fun play() {
        var indicator = false
        while (model.state!= Model.Condition.Finish && !indicator) {
            val input = readln()
            for (i in input.indices) {
                try {
                    when (input[i]) {
                        'w' -> model.makeStep(Model.Move.Up)
                        's' -> model.makeStep(Model.Move.Down)
                        'a' -> model.makeStep(Model.Move.Left)
                        'd' -> model.makeStep(Model.Move.Right)
                        'e' -> {
                            model.saveGame()
                            indicator = true
                            break
                        }
                        else -> model.makeStep(Model.Move.Stay)
                    }
                } catch (e: Exception) {
                    println(e.message)
                }
            }
        }
    }
}