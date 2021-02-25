package com.example.flickerphotossearexample.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */
abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bindView(item: RecyclerViewListItem)

}