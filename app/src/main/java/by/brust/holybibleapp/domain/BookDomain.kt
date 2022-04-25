package by.brust.holybibleapp.domain

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.data.Book
import by.brust.holybibleapp.presentation.BooksUI
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class BookDomain : Abstract.Object<BooksUI, BooksDomainToUIMapper>() {

    class Success(private val books: List<Book>) : BookDomain() {
        override fun map(mapper: BooksDomainToUIMapper) = mapper.map(books)
    }


class Fail(private val exception: Exception) : BookDomain() {
    override fun map(mapper: BooksDomainToUIMapper) =  mapper.map(
         when(exception) {
            is UnknownHostException -> ErrorType.NO_CONNECTION
            is HttpException -> ErrorType.SERVICE_UNAVAILABLE
            else -> ErrorType.GENERIC_ERROR
        })
}
}