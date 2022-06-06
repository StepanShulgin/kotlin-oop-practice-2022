package labOOP3.NoteBank

import labOOP3.Note
import java.net.URL

interface NoteAppInterface{


    val noteList: ArrayList<Note>

    fun addTextNote(title:String, textOfNote : String): Note.TextNote
    fun addTaskNote(title:String, textOfTask:String,deadline: String): Note.TaskNote
    fun addLinkNote(title: String, url: URL): Note.LinkNote
    fun deleteNote(note: Note)

    fun sortByTitle(): List<Note>
    fun sortByDate(): List<Note>


    fun getNoteList(): List<Note>
    fun getAllTextNotes(): List<Note.TextNote>
    fun getAllTaskNotes(): List<Note.TaskNote>
    fun getAllLinkNotes(): List<Note.LinkNote>

    fun TypeSeacher(type: Class<Any>): List<Note>
    fun TitleSeacher(title: String): List<Note>


}