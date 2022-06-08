package labOOP4

import labOOP4.controller.Controller
import labOOP4.model.Model
import labOOP4.view.ConsoleUI


fun main(){
    val maze = Model()
    ConsoleUI(maze)
    Controller(maze)
}