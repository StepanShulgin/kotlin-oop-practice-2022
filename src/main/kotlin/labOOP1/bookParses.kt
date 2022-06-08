package labOOP1

data class Book(val title: String, val authors: MutableList<String>, val year: Int)

fun parseBooks(bookString: String): List<Book> {
    val mainSeporator = '/'
    val bookSeparator = '\n'
    val authorSeporator = ','
    var temporaryString = ""
    var index = 0
    var calculator = 0
    val bookList = mutableListOf<Book>()
    var title = ""
    var yearOfPub: String
    var authorSafe: String
    var counterOfSlash = 0
    val authorList = mutableListOf<String>()


    while (index != bookString.length - 1) {
        if (bookString[index] == mainSeporator && counterOfSlash == 0 && calculator == 0) {
            title = (temporaryString.trim().subSequence(2, temporaryString.trim().length)).trim() as String
            temporaryString = ""
            calculator++
            counterOfSlash++

        } else if (bookString[index] == mainSeporator && counterOfSlash == 1) {
            temporaryString = ""
            counterOfSlash = 0
        } else if (bookString[index] == authorSeporator && calculator == 1) {

            authorSafe = temporaryString.trim()
            authorList.add(authorSafe)
            temporaryString = ""

        } else if (bookString[index] == mainSeporator && calculator == 1 && counterOfSlash == 0) {
            authorSafe = temporaryString.trim()
            authorList.add(authorSafe)
            temporaryString = ""
            counterOfSlash++
            calculator++
        } else if (bookString[index] == bookSeparator) {
            yearOfPub = temporaryString.trim()

            temporaryString = ""
            calculator = 0

            bookList.add(Book(title, mutableListOf(), yearOfPub.toInt()))
            for (i in 0 until authorList.size) {
                (bookList[bookList.size - 1].authors).add(i, authorList[i])
            }
            authorList.clear()
        } else if (bookString[index] != mainSeporator && bookString[index] != authorSeporator && bookString[index] != bookSeparator) {
            temporaryString += bookString[index]

        }
        index++
    }
    if (index == bookString.length - 1) {
        temporaryString += bookString[index]
        yearOfPub = temporaryString.trim()
        bookList.add(Book(title, mutableListOf(), yearOfPub.toInt()))
        for (i in 0 until authorList.size) {
            (bookList[bookList.size - 1].authors).add(i, authorList[i])
        }

        authorList.clear()

    }

    return bookList
}
