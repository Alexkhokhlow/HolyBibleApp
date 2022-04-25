package by.brust.holybibleapp.core

import android.app.Application
import by.brust.holybibleapp.data.BooksCloudDataSource
import by.brust.holybibleapp.data.BooksCloudMapper
import by.brust.holybibleapp.data.BooksRepository
import by.brust.holybibleapp.data.cache.BookCacheMapper
import by.brust.holybibleapp.data.cache.BooksCacheDataSource
import by.brust.holybibleapp.data.cache.BooksCacheMapper
import by.brust.holybibleapp.data.cache.RealmProvider
import by.brust.holybibleapp.data.net.BookCloudMapper
import by.brust.holybibleapp.data.net.BooksService
import retrofit2.Retrofit
import by.brust.holybibleapp.domain.BaseBooksDataToDomainMapper
import by.brust.holybibleapp.domain.BookInteractor
import by.brust.holybibleapp.presentation.BaseBooksDomainToUIMapper
import by.brust.holybibleapp.presentation.BooksCommunication
import by.brust.holybibleapp.presentation.MainViewModel
import by.brust.holybibleapp.presentation.ResourceProvider

class BibleApp: Application() {

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        val service = retrofit.create(BooksService::class.java)

        val cloudDataSource = BooksCloudDataSource.Base(service)
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())

        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )

        val bookInteractor = BookInteractor.Base(booksRepository, BaseBooksDataToDomainMapper())

        mainViewModel = MainViewModel(
            bookInterator,
            BaseBooksDomainToUIMapper(
                BooksCommunication.Base(),
                ResourceProvider.Base(this)
            )
        )
    }
}