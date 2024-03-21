package com.pcdevv.e_perpus.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pcdevv.e_perpus.R
import com.pcdevv.e_perpus.adapters.BookAdapter
import com.pcdevv.e_perpus.databinding.FragmentHomeBinding
import com.pcdevv.e_perpus.ui.BookViewModel
import com.pcdevv.e_perpus.ui.MainActivity
import com.pcdevv.e_perpus.utils.Resource

const val TAG = "HomeFragment"

class HomeFragment: Fragment(R.layout.fragment_home) {

    lateinit var viewModel: BookViewModel
    lateinit var bookAdapter: BookAdapter
    lateinit var binding: FragmentHomeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        binding = FragmentHomeBinding.bind(view)
        setupRecyclerView()

        viewModel.books.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { bookResponse ->
                        bookAdapter.differ.submitList(bookResponse.data)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                       Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }

//                else -> {}
            }
        })
    }

    private fun hideProgressBar() {
        binding.paginationProgressBar.visibility = View.INVISIBLE
    }
    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
    }
    private fun setupRecyclerView() {
        bookAdapter = BookAdapter()
        binding.rvHome.apply {
            adapter = bookAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}