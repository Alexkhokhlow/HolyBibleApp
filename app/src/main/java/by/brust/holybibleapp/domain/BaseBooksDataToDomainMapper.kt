package by.brust.holybibleapp.domain

import by.brust.holybibleapp.data.Book
import by.brust.holybibleapp.data.BooksDataToDomainMapper

class BaseBooksDataToDomainMapper: BooksDataToDomainMapper {
    override fun map(books: List<Book>) = BookDomain.Success(books)
    override fun map(exception: Exception) = BookDomain.Fail(exception)
}