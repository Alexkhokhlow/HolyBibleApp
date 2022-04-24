package by.brust.holybibleapp.data.cache

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.core.Book
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb : RealmObject(), Abstract.Mapable<Book, BookCacheMapper> {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""
    override fun map(mapper: BookCacheMapper) = Book(id, name)
}
