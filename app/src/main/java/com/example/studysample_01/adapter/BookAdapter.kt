package com.example.studysample_01.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studysample_01.R
import com.example.studysample_01.databinding.CellBookInfoBinding
import com.example.studysample_01.view.model.BookInfo



// TODO : ListAdapter 변경
class BookAdapter(
    private val bookList: List<BookInfo>
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cell_book_info, parent, false)
        return BookViewHolder(CellBookInfoBinding.bind(view))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindWithView(bookList[position])
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    inner class BookViewHolder(private val binding: CellBookInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindWithView(bookInfo: BookInfo) {
            binding.model = bookInfo
            binding.executePendingBindings()
            // TODO : binding.executePendingBindings()
        }
    }
}