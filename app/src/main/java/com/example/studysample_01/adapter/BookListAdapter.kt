package com.example.studysample_01.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.studysample_01.R
import com.example.studysample_01.databinding.CellBookInfoBinding
import com.example.studysample_01.view.model.BookInfo

class BookListAdapter(
    private val bookList: List<BookInfo>
) : ListAdapter<BookInfo, BookListAdapter.BookListViewHolder>(
    object : DiffUtil.ItemCallback<BookInfo>() {
        override fun areItemsTheSame(oldItem: BookInfo, newItem: BookInfo): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: BookInfo, newItem: BookInfo): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cell_book_info, parent, false)
        return BookListViewHolder(CellBookInfoBinding.bind(view))
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {

        holder.bindWithView(item = bookList[position])
    }

    inner class BookListViewHolder(private val binding: CellBookInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindWithView(item: BookInfo) {
            binding.model = item
            binding.executePendingBindings()
        }

    }
}