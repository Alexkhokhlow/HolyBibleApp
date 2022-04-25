package by.brust.holybibleapp.domain

import by.brust.holybibleapp.data.BooksDataToDomainMapper
import by.brust.holybibleapp.data.BooksRepository
import by.brust.holybibleapp.presentation.BooksUI

interface BookInteractor {
    suspend fun fetchBooks(): BookDomain

    class Base(private val booksRepository: BooksRepository,
        private val mapper: BooksDataToDomainMapper) : BookInteractor {
        override suspend fun fetchBooks()= booksRepository.fetchBooks().map(mapper)
    }
}