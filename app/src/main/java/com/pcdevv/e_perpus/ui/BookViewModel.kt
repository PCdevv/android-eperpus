package com.pcdevv.e_perpus.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pcdevv.e_perpus.models.BookResponse
import com.pcdevv.e_perpus.repository.BookRepository
import com.pcdevv.e_perpus.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class BookViewModel(
    val bookRepository: BookRepository
) : ViewModel() {

    val books: MutableLiveData<Resource<BookResponse>> = MutableLiveData()

    init {
        getBooks()
    }

    fun getBooks() = viewModelScope.launch {
        books.postValue(Resource.Loading())
        val response = bookRepository.getBooks()
        books.postValue(handleBooksResponse(response))
    }

    private fun handleBooksResponse(response: Response<BookResponse>) : Resource<BookResponse> {
        if (response.isSuccessful){
            response.body()?.let {resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}