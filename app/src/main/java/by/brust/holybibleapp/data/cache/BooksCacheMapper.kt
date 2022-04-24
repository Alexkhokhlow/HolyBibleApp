package by.brust.holybibleapp.data.cache

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.core.Book

interface BooksCacheMapper : Abstract.Mapper {

    fun map(books: List<BookDb>) : List<Book>

    class Base(private val mapper: BookCacheMapper): BooksCacheMapper {
        override fun map(books: List<BookDb>) =  books.map {
               bookDb ->
                bookDb.map(mapper)
           }
    }
}