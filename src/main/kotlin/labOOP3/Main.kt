package labOOP3

import labOOP3.NoteBank.NoteApp
import java.net.URL

enum class Title(val title: String)
{
    firstTextTitle("First warning"),
    secondTextTitle("Second warning"),
    firstTaskTitle("Prepare for the first exam"),
    secondTaskTitle("Prepare for the second exam"),
    firstLinkTitle("Loqiemean — Koalko"),
    secondLinkTitle("Noize MC — Voyager-1")
}
enum class TextOfNote(val text: String){
    FirstText("Don't forget to turn off the iron"),
    SecondText("Did not fail the exams")
}
enum class TestOfTask(val task:String){
    FirstTask("Theoretical foundations of electrical engineering"),
    SecondTask("Mathematical logic and theory of algorithms")

}

enum class UrlLink(val link: URL){
    Koalko(URL("https://www.youtube.com/watch?v=s3UwaIU8sJg")),
    Voyager(URL("https://www.youtube.com/watch?v=zX3KFKy9P54"))
}

enum class DeadLineDate(val deadline: String)
{
    FirstExDate("14 6 2022"),
    SecondExDate("18 6 2022")
}
fun main(){

    val notes= NoteApp()
    notes.addTextNote(Title.firstTextTitle.title, TextOfNote.FirstText.text)
    notes.addTaskNote(Title.firstTaskTitle.title,TestOfTask.FirstTask.task,DeadLineDate.FirstExDate.deadline)
    notes.addLinkNote(Title.firstLinkTitle.title,UrlLink.Koalko.link)
    notes.addTextNote(Title.secondTextTitle.title, TextOfNote.SecondText.text)
    notes.addTaskNote(Title.secondTaskTitle.title,TestOfTask.SecondTask.task,DeadLineDate.SecondExDate.deadline)
    notes.addLinkNote(Title.secondLinkTitle.title,UrlLink.Voyager.link)
    println("Notes: ${notes.getNoteList()}")
    //Other methods in tests

}