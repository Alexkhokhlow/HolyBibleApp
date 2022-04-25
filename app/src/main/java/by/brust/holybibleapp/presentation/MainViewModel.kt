package by.brust.holybibleapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.brust.holybibleapp.core.Abstract
import by.brust.holybibleapp.data.Book
import by.brust.holybibleapp.domain.BooksDomainToUIMapper
import by.brust.holybibleapp.domain.BooksInterator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val bookInteractor: BooksInterator,
                    private val mapper: BooksDomainToUIMapper,
private val communication: BooksCommunication) : ViewModel() {

   fun fetchBooks() = viewModelScope.launch(Dispatchers.IO) {
       val result = bookInteractor.fetchBooks().map(mapper)
       with(Dispatchers.Main) {
        result.map(Abstract.Mapper.Empty())
       }
   }

    fun observe(owner: LifecycleOwner, observer:Observer<List<Book>>) {
        communication.observeSuccess(owner,observer)
    }
}