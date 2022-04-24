package by.brust.holybibleapp.core

import android.app.Application
import by.brust.holybibleapp.data.BooksRepository
import by.brust.holybibleapp.domain.BaseBooksDataToDomainMapper
import by.brust.holybibleapp.domain.BookInteractor

class BibleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val booksRepository: BooksRepository = TODO("merge")
        val bookInteractor = BookInteractor.Base(booksRepository, BaseBooksDataToDomainMapper())
    }
}