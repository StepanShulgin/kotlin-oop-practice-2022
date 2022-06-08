package labOOP3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.net.URL

enum class Title(val title: String) {
    FirstTextTitle("First warning"),
    FirstTaskTitle("Prepare for the first exam"),
    SecondTaskTitle("Prepare for the second exam"),
    FirstLinkTitle("Loqiemean — KoAlko"),
}

enum class TextOfNote(val text: String) {
    FirstText("Don't forget to turn off the iron"),
}

enum class TestOfTask(val task: String) {
    FirstTask("Theoretical foundations of electrical engineering"),
    SecondTask("Mathematical logic and theory of algorithms")

}

enum class UrlLink(val link: URL) {
    Alcohol(URL("https://www.youtube.com/watch?v=s3UwaIU8sJg")),
}



enum class DeadLineDate(val deadline: String) {
    FirstExDate("14 6 2022"),
    SecondExDate("18 6 2022")
}

enum class Result(val res: String) {
    TwoMembersText("[\nTitle = First warning\nDate of creation: 7.5.2022\nYour note:\nDon't forget to turn off the iron, \nTitle = Prepare for the first exam\nDate of creation: 7.5.2022\nYour note:\nTask: Theoretical foundations of electrical engineering\nDeadline: 14.6.2022]"),
    OneMemberText("[\nTitle = First warning\nDate of creation: 7.5.2022\nYour note:\nDon't forget to turn off the iron]"),
    OneMemberLink("[\nTitle = Loqiemean — Koalko\nDate of creation: 7.5.2022\nYour Link:\nhttps://www.youtube.com/watch?v=s3UwaIU8sJg]"),
    OneMember("[\nTitle = Prepare for the first exam\nDate of creation: 7.5.2022\nYour note:\nTask: Theoretical foundations of electrical engineering\nDeadline: 14.6.2022]"),
    SortTitle("\nTitle = Prepare for the first exam\nDate of creation: 7.5.2022\nYour note:\nTask: Theoretical foundations of electrical engineering\nDeadline: 14.6.2022"),
}

internal class NoteAppTest {

    @Test
    fun getNoteList() {
        val notes = NoteApp()
        notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
        notes.addTaskNote(Title.FirstTaskTitle.title, TestOfTask.FirstTask.task, DeadLineDate.FirstExDate.deadline)
        assertEquals(Result.TwoMembersText.res, notes.getNoteList().toString())
    }

    @Test
    fun addTextNote() {
        val notes = NoteApp()

        notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
        assertEquals(Result.OneMemberText.res, notes.getNoteList().toString())
    }

    @Test
    fun addTaskNote() {
        val notes = NoteApp()
        notes.addTaskNote(
            Title.FirstTaskTitle.title,
            TestOfTask.FirstTask.task,
            DeadLineDate.FirstExDate.deadline
        )
        assertEquals(Result.OneMember.res, notes.getNoteList().toString())

    }

    @Test
    fun addLinkNote() {
        val notes = NoteApp()
        notes.addLinkNote(Title.FirstLinkTitle.title, UrlLink.Alcohol.link)
        assertEquals(Result.OneMemberLink.res, notes.getNoteList().toString())
    }

    @Test
    fun deleteNote() {

    }

    @Test
    fun sortByTitle() {
        val notes = NoteApp()
        notes.addTaskNote(
            Title.SecondTaskTitle.title,
            TestOfTask.SecondTask.task,
            DeadLineDate.SecondExDate.deadline
        )
        notes.addTaskNote(
            Title.FirstTaskTitle.title,
            TestOfTask.FirstTask.task,
            DeadLineDate.FirstExDate.deadline
        )
        notes.sortByTitle()
        notes.getNoteList()[1]
        assertEquals(Result.SortTitle.res, notes.getNoteList()[1].toString())
    }

    @Test
    fun sortByDate() {
        val notes = NoteApp()
        notes.addTaskNote(
            Title.SecondTaskTitle.title,
            TestOfTask.SecondTask.task,
            DeadLineDate.SecondExDate.deadline
        )
        notes.addTaskNote(
            Title.FirstTaskTitle.title,
            TestOfTask.FirstTask.task,
            DeadLineDate.FirstExDate.deadline
        )
        notes.getNoteList()[1]
        assertEquals(Result.SortTitle.res, notes.getNoteList()[1].toString())
    }

    @Test
    fun getAllTextNotes() {
        val notes = NoteApp()
        notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
        notes.addTaskNote(
            Title.SecondTaskTitle.title,
            TestOfTask.SecondTask.task,
            DeadLineDate.SecondExDate.deadline
        )
        assertEquals(Result.OneMemberText.res, notes.getAllTextNotes().toString())
    }

    @Test
    fun getAllTaskNotes() {
        val notes = NoteApp()
        notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
        notes.addTaskNote(
            Title.FirstTaskTitle.title,
            TestOfTask.FirstTask.task,
            DeadLineDate.FirstExDate.deadline
        )
        assertEquals(Result.OneMember.res, notes.getAllTaskNotes().toString())
    }

    @Test
    fun getAllLinkNotes() {
        val notes = NoteApp()
        notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
        notes.addLinkNote(Title.FirstLinkTitle.title, UrlLink.Alcohol.link)
        assertEquals(Result.OneMemberLink.res, notes.getAllLinkNotes().toString())

    }

    @Test
    fun searchForTitle() {
        val notes = NoteApp()
        notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
        notes.addTaskNote(Title.FirstTaskTitle.title, TestOfTask.FirstTask.task, DeadLineDate.FirstExDate.deadline)
        notes.addLinkNote(Title.FirstLinkTitle.title, UrlLink.Alcohol.link)
        assertEquals(notes.searchForTitle("Loqiemean — Koalko").toString(), Result.OneMemberLink.res)
    }

}