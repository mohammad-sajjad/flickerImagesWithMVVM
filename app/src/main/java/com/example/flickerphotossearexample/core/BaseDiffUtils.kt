package com.example.flickerphotossearexample.core

import androidx.recyclerview.widget.DiffUtil


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */
class BaseDiffUtils(
    private val oldItems: MutableList<RecyclerViewListItem>,
    private val newItems: MutableList<RecyclerViewListItem>
) :
    DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return oldItem.getViewType() == newItem.getViewType() && oldItem.getUnique() == newItem.getUnique()

    }

    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return oldItem.getViewType() == newItem.getViewType() && oldItem.getUnique() == newItem.getUnique()
    }
}