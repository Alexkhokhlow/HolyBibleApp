package by.brust.holybibleapp.data

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.core.Book
import by.brust.holybibleapp.data.net.BookCloud
import by.brust.holybibleapp.domain.BookDomain

interface BooksDataToDomainMapper: Abstract.Mapper<Any?, Any?> {
    fun map(books: List<Book>) : BookDomain
    fun map(e:Exception) : BookDomain

    class Base: BooksDataToDomainMapper{
        override fun map(books: List<Book>): BookDomain {
           return BookDomain.Success()
        }

        override fun map(e: Exception): BookDomain {
           return BookDomain.Fail()
        }

    }
}