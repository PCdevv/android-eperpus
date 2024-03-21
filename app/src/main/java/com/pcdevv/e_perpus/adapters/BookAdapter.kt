package com.pcdevv.e_perpus.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pcdevv.e_perpus.databinding.BookListBinding
import com.pcdevv.e_perpus.models.Book

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: BookListBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Book>(){
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id_buku == newItem.id_buku
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)
//    private  val differ = AsyncListDiffer(this, diffCallback)
    var books: List<Book>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

//    override fun getItemCount() = books.size
    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(BookListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

//    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
//        holder.binding.apply {
//            val book = books[position]
//            tvTitle.text = book.judul_buku
//        }
//    }
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = differ.currentList[position]
        holder.binding.apply {
//            Glide.with(this).load(book.foto_cover).into(ivBookCover)
            tvTitle.text = book.judul_buku
            tvCategory.text = book.kategori.nama_kategori
            tvSubcategory.text = book.subkategori.nama_subkategori
//            tvAuthor.text = book.pengarang
//            tvReview.text = book.ulasan
            setOnClickListener {
                onItemClickListener?.let { it(book) }
            }
        }
    }

    private var onItemClickListener: ((Book) -> Unit)? = null
    fun setOnClickListener(listener: (Book) -> Unit) {
        onItemClickListener = listener
    }
}