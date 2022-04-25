package by.brust.holybibleapp.presentation

import by.brust.holybibleapp.data.Book
import by.brust.holybibleapp.domain.BooksDomainToUIMapper
import by.brust.holybibleapp.domain.ErrorType

class BaseBooksDomainToUIMapper(private val communication: BooksCommunication,
private val resourceProvider: ResourceProvider) :
    BooksDomainToUIMapper {
    override fun map(books: List<Book>) = BooksUI.Success(communication, books)
    override fun map(errorType: ErrorType) = BooksUI.Fail(communication, errorType, resourceProvider)
}