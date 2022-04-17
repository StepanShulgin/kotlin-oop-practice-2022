package labOOP1

import kotlin.String as String

data class Book(val title: String, val authors: MutableList<String>, val year: Int)

fun parseBooks(inputbooks: String): List<Book> {
    val mainSeporator = '/'
    val bookSeparator = '\n'
    val authorSeporator = ','
    var temporaryString = ""
    var index = 0
    var calculate = 0
    val bookList = mutableListOf<Book>()
    var title = ""
    var yearOfPub: String
    var tempauthor : String
    var countslash = 0
    val authorList = mutableListOf<String>()


    while (index !=inputbooks.length - 1) {
        if(inputbooks[index] == mainSeporator && countslash==0 && calculate == 0)
        {
            title = (temporaryString.trim().subSequence(2,temporaryString.trim().length)).trim() as String
            temporaryString = ""
            calculate++
            countslash++

        }
        else if(inputbooks[index]== mainSeporator && countslash == 1 )
        {
            temporaryString=""
            countslash=0
        }

        else if(inputbooks[index] == authorSeporator && calculate == 1)
        {

            tempauthor = temporaryString.trim()
            authorList.add(tempauthor)
            temporaryString = ""

        }
        else if(inputbooks[index]==mainSeporator && calculate == 1 && countslash==0)
        {
            tempauthor = temporaryString.trim()
            authorList.add(tempauthor)
            temporaryString = ""
            countslash++
            calculate++
        }

        else if(inputbooks[index]==bookSeparator)
        {
            yearOfPub = temporaryString.trim()

            temporaryString=""
            calculate = 0

            bookList.add(Book(title, mutableListOf() , yearOfPub.toInt()))
            for(i in 0 until authorList.size)
            {
                (bookList[bookList.size-1].authors).add(i,authorList[i])
            }
            authorList.clear()
        }
        else if(inputbooks[index] != mainSeporator && inputbooks[index] != authorSeporator && inputbooks[index] != bookSeparator)
        {
            temporaryString += inputbooks[index]

        }
        index++
    }
    if(index ==inputbooks.length - 1)
    {
        temporaryString += inputbooks[index]
        yearOfPub = temporaryString.trim()
        bookList.add(Book(title, mutableListOf(), yearOfPub.toInt()))
        for(i in 0 until authorList.size)
        {
            (bookList[bookList.size-1].authors).add(i,authorList[i])
        }

        authorList.clear()

    }

    return bookList
}
