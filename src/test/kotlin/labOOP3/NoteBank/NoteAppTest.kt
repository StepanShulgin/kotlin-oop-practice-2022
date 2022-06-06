package labOOP3.NoteBank

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

enum class Title(val title: String)
{
    FirstTextTitle("First warning"),
    FirstTaskTitle("Prepare for the first exam"),
}
enum class TextOfNote(val text: String){
    FirstText("Don't forget to turn off the iron"),
}
enum class TestOfTask(val task:String){
    FirstTask("Theoretical foundations of electrical engineering"),

}

enum class DeadLineDate(val deadline: String)
{
    FirstExDate("14 6 2022"),
}
enum class Result(val res:String){
    TwoMembersText("[\nTitle = First warning\nDate of creation: 7.5.2022\nYour note:\nDon't forget to turn off the iron, \nTitle = Prepare for the first exam\nDate of creation: 7.5.2022\nYour note:\nTask: Theoretical foundations of electrical engineering\nDeadline: 14.6.2022]"),
    OneMemberText("[\nTitle = First warning\nDate of creation: 7.5.2022\nYour note:\nDon't forget to turn off the iron]"),
    OneMemberTask("[\nTitle = Loqiemean — Koalko\nDate of creation: 7.5.2022\nYour Link:\nhttps://www.youtube.com/watch?v=s3UwaIU8sJg]"),
    OneMember("[\nTitle = Prepare for the first exam\nDate of creation: 7.5.2022\nYour note:\nTask: Theoretical foundations of electrical engineering\nDeadline: 14.6.2022]"),
    SortTitle("\nTitle = Prepare for the first exam\nDate of creation: 7.5.2022\nYour note:\nTask: Theoretical foundations of electrical engineering\nDeadline: 14.6.2022"),
}

internal class NoteAppTest {

    @Test
    fun getNoteList() {
        val notes= NoteApp()
        notes.addTextNote(labOOP3.Title.firstTextTitle.title, labOOP3.TextOfNote.FirstText.text)
        notes.addTaskNote(Title.FirstTaskTitle.title,TestOfTask.FirstTask.task,DeadLineDate.FirstExDate.deadline)
        assertEquals(labOOP3.NoteBank.Result.TwoMembersText.res,notes.getNoteList().toString())
    }

    @Test
    fun addTextNote() {
        val notes= NoteApp()

        notes.addTextNote(labOOP3.Title.firstTextTitle.title, labOOP3.TextOfNote.FirstText.text)
        assertEquals(labOOP3.NoteBank.Result.OneMemberText.res,notes.getNoteList().toString())
    }

    @Test
    fun addTaskNote() {
        val notes= NoteApp()
        notes.addTaskNote(labOOP3.Title.firstTaskTitle.title, labOOP3.TestOfTask.FirstTask.task, labOOP3.DeadLineDate.FirstExDate.deadline)
        assertEquals(labOOP3.NoteBank.Result.OneMember.res,notes.getNoteList().toString())

    }

    @Test
    fun addLinkNote() {
        val notes= NoteApp()
        notes.addLinkNote(labOOP3.Title.firstLinkTitle.title, labOOP3.UrlLink.Koalko.link)
        assertEquals(labOOP3.NoteBank.Result.OneMemberTask.res,notes.getNoteList().toString())
    }

    @Test
    fun deleteNote() {

    }

    @Test
    fun sortByTitle() {
        val notes= NoteApp()
        notes.addTaskNote(labOOP3.Title.secondTaskTitle.title, labOOP3.TestOfTask.SecondTask.task, labOOP3.DeadLineDate.SecondExDate.deadline)
        notes.addTaskNote(labOOP3.Title.firstTaskTitle.title, labOOP3.TestOfTask.FirstTask.task, labOOP3.DeadLineDate.FirstExDate.deadline)
        notes.sortByTitle()
        notes.getNoteList()[1]
        assertEquals(labOOP3.NoteBank.Result.SortTitle.res,notes.getNoteList()[1].toString())
    }

    @Test
    fun sortByDate() {
        val notes= NoteApp()
        notes.addTaskNote(labOOP3.Title.secondTaskTitle.title, labOOP3.TestOfTask.SecondTask.task, labOOP3.DeadLineDate.SecondExDate.deadline)
        notes.addTaskNote(labOOP3.Title.firstTaskTitle.title, labOOP3.TestOfTask.FirstTask.task, labOOP3.DeadLineDate.FirstExDate.deadline)
        notes.getNoteList()[1]
        assertEquals(labOOP3.NoteBank.Result.SortTitle.res,notes.getNoteList()[1].toString())
    }

    @Test
    fun getAllTextNotes() {
        val notes= NoteApp()
        notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
        notes.addTaskNote(labOOP3.Title.secondTaskTitle.title, labOOP3.TestOfTask.SecondTask.task, labOOP3.DeadLineDate.SecondExDate.deadline)
        assertEquals(labOOP3.NoteBank.Result.OneMemberText.res, notes.getAllTextNotes().toString())
    }

    @Test
    fun getAllTaskNotes() {
        val notes= NoteApp()
        notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
        notes.addTaskNote(labOOP3.Title.firstTaskTitle.title, labOOP3.TestOfTask.FirstTask.task, labOOP3.DeadLineDate.FirstExDate.deadline)
        assertEquals(labOOP3.NoteBank.Result.OneMember.res, notes.getAllTaskNotes().toString())
    }

    @Test
    fun getAllLinkNotes() {
        val notes= NoteApp()
        notes.addTextNote(Title.FirstTextTitle.title, TextOfNote.FirstText.text)
        notes.addLinkNote(labOOP3.Title.firstLinkTitle.title, labOOP3.UrlLink.Koalko.link)
        assertEquals(labOOP3.NoteBank.Result.OneMemberTask.res,notes.getAllLinkNotes().toString())

    }

    @Test
    fun titleSeacher() {
        val notes = NoteApp()
        notes.addTextNote(labOOP3.Title.firstTextTitle.title, labOOP3.TextOfNote.FirstText.text)
        notes.addTaskNote(Title.FirstTaskTitle.title, TestOfTask.FirstTask.task, DeadLineDate.FirstExDate.deadline)
        notes.addLinkNote(labOOP3.Title.firstLinkTitle.title, labOOP3.UrlLink.Koalko.link)
        assertEquals(notes.TitleSeacher("Loqiemean — Koalko").toString(),labOOP3.NoteBank.Result.OneMemberTask.res)
    }

}