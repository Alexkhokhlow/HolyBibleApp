package by.brust.holybibleapp.core

import android.app.Application
import by.brust.holybibleapp.domain.BooksInterator
import by.brust.holybibleapp.presentation.BaseBooksDomainToUIMapper
import by.brust.holybibleapp.presentation.BooksCommunication
import by.brust.holybibleapp.presentation.MainViewModel
import by.brust.holybibleapp.presentation.ResourceProvider

class BibleApp : Application() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        val booksInterator: BooksInterator = TODO()
        mainViewModel = MainViewModel(
            booksInterator,
            BaseBooksDomainToUIMapper(
                BooksCommunication.Base(),
                ResourceProvider.Base(this)
            )
        )
    }
}