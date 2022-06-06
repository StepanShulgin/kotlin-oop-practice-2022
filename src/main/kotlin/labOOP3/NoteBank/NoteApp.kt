package labOOP3.NoteBank

import labOOP3.DaTe
import labOOP3.Note
import java.net.URL
import java.util.Calendar


class NoteApp():NoteAppInterface {
    override val noteList = arrayListOf<Note>()


    override fun addTextNote(title:String, textOfNote : String): Note.TextNote {
        noteList.add(Note.TextNote(title,getCurDate(),textOfNote))
        return Note.TextNote(title,getCurDate(),textOfNote)
    }

    override fun addTaskNote(title:String, textOfTask:String,deadline: String): Note.TaskNote {
        noteList.add(Note.TaskNote(title, getCurDate(), textOfTask, dateParser(deadline)))
        return Note.TaskNote(title, getCurDate(), textOfTask, dateParser(deadline))
    }

    override fun addLinkNote(title: String, url: URL): Note.LinkNote {
        noteList.add(Note.LinkNote(title, getCurDate(), url))
        return Note.LinkNote(title, getCurDate(), url)
    }

    override fun deleteNote(note: Note){noteList.remove(note)}

    override fun sortByTitle(): List<Note> = noteList.sortedBy {it.title}

    override fun sortByDate(): List<Note> = noteList.sortedBy {it.dateOfCreate.toString()}

    override fun getNoteList(): List<Note> = noteList

    override fun getAllTextNotes(): List<Note.TextNote> = noteList.filterIsInstance<Note.TextNote>()

    override fun getAllTaskNotes(): List<Note.TaskNote> = noteList.filterIsInstance<Note.TaskNote>()

    override fun getAllLinkNotes(): List<Note.LinkNote> = noteList.filterIsInstance<Note.LinkNote>()

    override fun TypeSeacher(type: Class<Any>): List<Note> = noteList.filter {it.javaClass == type}

    override fun TitleSeacher(title: String): List<Note> = noteList.filter {it.title == title}

    private fun dateParser(time:String): DaTe {//Example of java.util.Calendar output: Tue Jun 07 19:01:05 MSK 2022
        val seporator = ' '
        time.trim()
        return DaTe(time.substringBefore(seporator).toInt(),time.substringAfter(seporator).substringBeforeLast(seporator).toInt(),time.substringAfterLast(seporator).toInt())

    }
    private fun getCurDate():DaTe {
        val currdate = Calendar.getInstance()
        val year = currdate.get(Calendar.YEAR)
        val month = currdate.get(Calendar.MONTH)
        val day = currdate.get(Calendar.DAY_OF_MONTH)

        return(DaTe(day,month, year))
    }


}

