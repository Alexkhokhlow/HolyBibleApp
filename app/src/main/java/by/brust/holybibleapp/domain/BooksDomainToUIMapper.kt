package by.brust.holybibleapp.domain

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.data.Book
import by.brust.holybibleapp.presentation.BooksUI

interface BooksDomainToUIMapper: Abstract.Mapper {
    fun map(books: List<Book>) : BooksUI

    fun map(errorType: ErrorType) : BooksUI
}