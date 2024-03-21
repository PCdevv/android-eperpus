package com.pcdevv.e_perpus.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.pcdevv.e_perpus.R
import com.pcdevv.e_perpus.databinding.ActivityMainBinding
import com.pcdevv.e_perpus.db.BookDatabase
import com.pcdevv.e_perpus.repository.BookRepository

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var bookAdapter: BookAdapter
    lateinit var viewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.libraryNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        val bookRepository = BookRepository(BookDatabase(this))
        val viewModelProviderFactory = BookViewModelProviderFactory(bookRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(BookViewModel::class.java)
        binding.bottomNavigationView.setupWithNavController(navController)

//        setupRecyclerView()
//
//        lifecycleScope.launchWhenCreated {
//            binding.progressBar.isVisible = true
//            val response = try {
//                RetrofitInstance.api.getBooks()
//            } catch (e: IOException){
//                Log.e(TAG, "IOException, you might not have internet connection")
//                binding.progressBar.isVisible = false
//                return@launchWhenCreated
//            } catch (e: HttpException){
//                Log.e(TAG, "HttpException, unexpected response")
//                binding.progressBar.isVisible = false
//                return@launchWhenCreated
//            }
//            if (response.isSuccessful && response.body() != null){
//                bookAdapter.books = response.body()!!
//            } else{
//                Log.e(TAG, "Response not successful")
//            }
//            binding.progressBar.isVisible = false
//        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
    }
//
//    private fun setupRecyclerView() = binding.rvBooks.apply {
//        bookAdapter = BookAdapter()
//        adapter = bookAdapter
//        layoutManager= LinearLayoutManager(this@MainActivity)
//    }
}