package com.example.flickerphotossearexample.core

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */


abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    // all the elements for this adapter
    private var items: MutableList<RecyclerViewListItem> = mutableListOf()

    private var viewGroup: ViewGroup? = null
    // the delegates needed for this adapter
    protected var delegates = HashMap<Int, DelegateInterface>()

    override fun getItemCount(): Int {
        // Log.d("infinite item size", "" + items.size)
        return items.size
    }

    fun getItemAtPosition(position: Int): RecyclerViewListItem {
        return items[position]
    }

    fun getItemAt(postion: Int): RecyclerViewListItem {
        return items[postion]
    }

    fun updateData(items: MutableList<RecyclerViewListItem>) {
        val diffResult = DiffUtil.calculateDiff(BaseDiffUtils(this.items, items))
        this.items.clear()
        this.items.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    abstract fun initDelegates()

    override fun getItemViewType(position: Int) = items[position].getViewType()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        delegates[getItemViewType(position)]?.onBindViewHolder(holder, items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        viewGroup = parent
        return try {
            delegates[viewType]?.onCreateViewHolder(parent)!!
        } catch (e: KotlinNullPointerException) {
            throw NoDelegateFoundException(viewType, this::class.java.simpleName)
        }
    }
}