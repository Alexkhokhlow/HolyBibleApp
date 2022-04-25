package by.brust.holybibleapp.domain

import by.brust.holybibleapp.data.BooksDataToDomainMapper
import by.brust.holybibleapp.data.BooksRepository

interface BookInteractor {
    suspend fun fetchBooks(): BooksDomain

    class Base(
        private val booksRepository: BooksRepository,
        private val mapper: BooksDataToDomainMapper
    ) : BookInteractor {
        override suspend fun fetchBooks() = booksRepository.fetchBooks().map(mapper)
    }
}