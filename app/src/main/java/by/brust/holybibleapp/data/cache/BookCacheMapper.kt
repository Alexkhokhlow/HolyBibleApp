package by.brust.holybibleapp.data.cache

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.core.Book

interface BookCacheMapper : Abstract.Mapper {

    fun map(bookDb: BookDb): Book

    class Base : BookCacheMapper {
        override fun map(bookDb: BookDb) = Book(bookDb.id, bookDb.name)

    }
}