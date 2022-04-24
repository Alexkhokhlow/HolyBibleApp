package by.brust.holybibleapp.data

import by.brust.holybibleapp.data.net.BookCloud
import by.brust.holybibleapp.data.net.BooksService

interface BooksCloudDataSource {
    suspend fun fetchBooks(): List<BookCloud>

    class Base(private val service: BooksService): BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookCloud> {
            return service.fetchBooks()
        }
    }
}