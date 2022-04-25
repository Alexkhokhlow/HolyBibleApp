package by.brust.holybibleapp.presentation

import by.brust.holybibleapp.R
import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.data.Book
import by.brust.holybibleapp.domain.ErrorType

sealed class BooksUI : Abstract.Object<Unit, Abstract.Mapper.Empty>() {

    class Success(
        private val communication: BooksCommunication,
        private val books: List<Book>
    ) : BooksUI() {
        override fun map(mapper: Abstract.Mapper.Empty) = communication.show(books)
    }


    class Fail(private val communication: BooksCommunication,
               private val errorType: ErrorType,
    private val resourceProvider: ResourceProvider) :
        BooksUI() {
        override fun map(mapper: Abstract.Mapper.Empty) {
            val messageId = when(errorType) {
                ErrorType.NO_CONNECTION -> R.string.no_connection_message
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavalable_message
                else -> R.string.something_went_wrong
            }
            communication.show(resourceProvider.getString(messageId))
        }

    }
}