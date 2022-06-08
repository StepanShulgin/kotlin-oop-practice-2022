package labOOP1

fun main() {
    var number: Int
    var member: Book
    val bookString: String = "1. The burden of human passions //Somerset Maugham//2007\n" +
            "2.Coraline//Neil Gaiman//2000\n" +
            "3.Good omens//Terry Pratchett, Neil Gaiman //2011"

    val bookList: List<Book> = parseBooks(bookString)
    println("\nThe oldest:")
    println(findOld(bookList))
    println("\nThe newest:")
    println(findNew(bookList))
    println("\nThe longest:")
    println(findLong(bookList))
    println("\nThe shortest:")
    println(findShort(bookList))

    println("\nThe whole book list:\n")
    for (i in bookList.indices) {
        number = i + 1
        member = bookList[i]
        println(" $number) $member\n")
    }

}

