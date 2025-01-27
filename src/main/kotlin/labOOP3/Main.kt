package labOOP3

import java.net.URL

enum class Title(val title: String) {
    FirstTextTitle("First warning"),
    SecondTextTitle("Second warning"),
    FirstTaskTitle("Prepare for the first exam"),
    SecondTaskTitle("Prepare for the second exam"),
    FirstLinkTitle("Loqiemean — KoAlko"),
    SecondLinkTitle("Noize MC — Voyager-1")
}

enum class TextOfNote(val text: String) {
    FirstText("Don't forget to turn off the iron"),
    SecondText("Did not fail the exams")
}

enum class TestOfTask(val task: String) {
    FirstTask("Theoretical foundations of electrical engineering"),
    SecondTask("Mathematical logic and theory of algorithms")

}

enum class UrlLink(val link: URL) {
    Alcohol(URL("https://www.youtube.com/watch?v=s3UwaIU8sJg")),
    Voyager(URL("https://www.youtube.com/watch?v=zX3KFKy9P54"))
}

enum class DeadLineDate(val deadline: String) {
    FirstExDate("14 6 2022"),
    SecondExDate("18 6 2022")
}

fun main() {

    val notes = NoteApp()
    notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
    notes.addTaskNote(Title.FirstTaskTitle.title, TestOfTask.FirstTask.task, DeadLineDate.FirstExDate.deadline)
    notes.addLinkNote(Title.FirstLinkTitle.title, UrlLink.Alcohol.link)
    notes.addTextNote(Title.SecondTextTitle.title, TextOfNote.SecondText.text)
    notes.addTaskNote(Title.SecondTaskTitle.title, TestOfTask.SecondTask.task, DeadLineDate.SecondExDate.deadline)
    notes.addLinkNote(Title.SecondLinkTitle.title, UrlLink.Voyager.link)
    println("Notes: ${notes.getNoteList()}")
    //Other methods in tests

}