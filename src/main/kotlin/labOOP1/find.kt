package labOOP1


fun findNew(bookList: List<Book>): Book
{
    var searchableBook = Int.MIN_VALUE
    var save = bookList[0]

    for (i in bookList)
    {
        if (i.year > searchableBook)
        {
            searchableBook = i.year
            save = i
        }
    }

    return save
}

fun findOld(bookList: List<Book>): Book
{
    var searchableBook = Int.MAX_VALUE
    var save : Book = bookList[0]

    for (i in bookList)
    {
        if (i.year < searchableBook)
        {
            searchableBook = i.year
            save = i

        }
    }

    return save
}

fun findLong(bookList: List<Book>): Book
{
    var searchableBook = Int.MIN_VALUE
    var save : Book = bookList[0]

    for (i in bookList) {
        if (i.title.length > searchableBook)
        {
            searchableBook = i.title.length
            save = i
        }
    }

    return save
}

fun findShort(bookList: List<Book>): Book
{
    var searchableBook = Int.MAX_VALUE
    var save : Book = bookList[0]

    for (i in bookList)
    {
        if (i.title.length < searchableBook)
        {
            searchableBook = i.title.length
            save = i
        }
    }

    return save
}

