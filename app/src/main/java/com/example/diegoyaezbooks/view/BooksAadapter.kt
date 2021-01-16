package com.example.diegoyaezbooks.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diegoyaezbooks.databinding.BookListItemBinding
import com.example.diegoyaezbooks.model.Books

class BooksAadapter : RecyclerView.Adapter<BooksAadapter.BooksVH>() {

    private var booksList = listOf<Books>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        val binding = BookListItemBinding.inflate(LayoutInflater.from(parent.context))
        return BooksVH(binding)
    }

    override fun onBindViewHolder(holder: BooksVH, position: Int) {
        val bookss = booksList[position]
        holder.bind(bookss)
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
        binding.tvName.text = books.title
    }
    }
}