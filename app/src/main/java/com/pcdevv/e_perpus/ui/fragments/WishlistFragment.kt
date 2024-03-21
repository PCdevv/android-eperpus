package com.pcdevv.e_perpus.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pcdevv.e_perpus.R
import com.pcdevv.e_perpus.ui.BookViewModel
import com.pcdevv.e_perpus.ui.MainActivity

class WishlistFragment: Fragment(R.layout.fragment_wishlist) {

    lateinit var viewModel: BookViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }
}