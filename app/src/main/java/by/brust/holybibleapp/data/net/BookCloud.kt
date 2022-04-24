package by.brust.holybibleapp.data.net

import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.core.Book
import by.brust.holybibleapp.data.BookData
import com.google.gson.annotations.SerializedName

data class BookCloud(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String
): Abstract.Object<Book, BookCloudMapper>(){
    override fun map(mapper: BookCloudMapper) = mapper.map(id, name)
}

