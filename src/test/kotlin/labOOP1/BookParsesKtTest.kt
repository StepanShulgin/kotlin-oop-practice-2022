package labOOP1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BookKtTest {

    @Test
    fun bookParserTest() {
        val bookString: String = "1. The burden of human passions //Somerset Maugham//2007\n" +
                "2.Coraline//Neil Gaiman//2000\n" +
                "3.Good omens//Terry Pratchett, Neil Gaiman //2011"

        val bookList: List<Book> = parseBooks(bookString)

        assertEquals(bookList[0].title, "The burden of human passions")
        assertEquals(bookList[0].authors[0], "Somerset Maugham")
        assertEquals(bookList[0].year, 2007)
        assertEquals(bookList[1].title, "Coraline")
        assertEquals(bookList[1].authors[0], "Neil Gaiman")
        assertEquals(bookList[1].year, 2000)
        assertEquals(bookList[2].title, "Good omens")
        assertEquals(bookList[2].authors[0], "Terry Pratchett")
        assertEquals(bookList[2].authors[1], "Neil Gaiman")
        assertEquals(bookList[2].year, 2011)


    }
}