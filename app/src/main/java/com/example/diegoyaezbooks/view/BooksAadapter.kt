package com.example.diegoyaezbooks.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.diegoyaezbooks.R
import com.example.diegoyaezbooks.databinding.BookListItemBinding
import com.example.diegoyaezbooks.model.pojos.Books
import com.squareup.picasso.Picasso

class BooksAadapter : RecyclerView.Adapter<BooksAadapter.BooksVH>() {
    private var booksList = listOf<Books>()
    private val selectedItem = MutableLiveData<Books>()
    fun selectedItem() : LiveData<Books> = selectedItem

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        val binding = BookListItemBinding.inflate(LayoutInflater.from(parent.context))
        return BooksVH(binding)
    }

    override fun onBindViewHolder(holder: BooksVH, position: Int) {
        val bookss = booksList[position]
        holder.bind(bookss)
        holder.itemView.setOnClickListener {
            selectedItem.value=bookss
        }
    }

    override fun getItemCount(): Int {
        return booksList.size
    }
    fun update(pBooksList:List<Books>){
        booksList=pBooksList
        notifyDataSetChanged()
    }

    class BooksVH(val binding : BookListItemBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(books: Books){
        binding.tvName.text = books.country
        }
    }
}