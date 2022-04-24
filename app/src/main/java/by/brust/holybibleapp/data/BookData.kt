package by.brust.holybibleapp.data

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.core.Book
import by.brust.holybibleapp.data.net.BookCloud
import by.brust.holybibleapp.domain.BookDomain

sealed class BooksData: Abstract.Object<BookDomain, BooksDataToDomainMapper>() {
    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(books)
    }

    class Fail(private val exception: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(exception)
        }
}
