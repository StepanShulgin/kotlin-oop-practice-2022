package labOOP3

import java.net.URL

sealed class Note(open var title:String, open var dateOfCreate:DaTe){

    data class TextNote(override var title:String, override var dateOfCreate: DaTe, var textOfNote: String):Note(title,dateOfCreate){
        override fun toString() = "\nTitle = $title\nDate of creation: $dateOfCreate\nYour note:\n$textOfNote"
    }
    data class TaskNote(override var title:String, override var dateOfCreate : DaTe, var textOfTask: String, var deadline: DaTe):Note(title,dateOfCreate){
        override fun toString() = "\nTitle = $title\nDate of creation: $dateOfCreate\nYour note:\nTask: $textOfTask\nDeadline: $deadline"
    }
    data class LinkNote(override var title: String, override var dateOfCreate: DaTe, var url: URL):Note(title,dateOfCreate){
        override fun toString() = "\nTitle = $title\nDate of creation: $dateOfCreate\nYour Link:\n$url"
    }


}

