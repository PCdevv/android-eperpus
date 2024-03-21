package com.pcdevv.e_perpus.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pcdevv.e_perpus.repository.BookRepository

class BookViewModelProviderFactory(
    val bookRepository: BookRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookViewModel(bookRepository) as T
    }
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return BookViewModel(bookRepository) as T
//    }
}