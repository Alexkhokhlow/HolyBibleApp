package by.brust.holybibleapp.data

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.core.Book
import by.brust.holybibleapp.data.net.BookCloud
import by.brust.holybibleapp.data.net.BookCloudMapper

interface BooksCloudMapper: Abstract.Mapper<Any?, Any?> {
    fun map(cloudList: List<BookCloud>) : List<Book>

    class Base(private val bookMapper: BookCloudMapper): BooksCloudMapper {
        override fun map(cloudList: List<BookCloud>) = cloudList.map{ bookCloud ->
              bookCloud.map(bookMapper)
          }
        }
}