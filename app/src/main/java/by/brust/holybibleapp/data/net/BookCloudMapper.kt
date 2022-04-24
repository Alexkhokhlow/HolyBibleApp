package by.brust.holybibleapp.data.net

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.core.Book

interface BookCloudMapper : Abstract.Mapper<Any?, Any?> {
    fun map(id: Int, name: String): Book

    class Base : BookCloudMapper {
        override fun map(id: Int, name: String) = Book(id, name)
    }
}
