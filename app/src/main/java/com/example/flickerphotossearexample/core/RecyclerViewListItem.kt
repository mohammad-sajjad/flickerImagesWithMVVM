package com.example.flickerphotossearexample.core


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */

interface RecyclerViewListItem {
    fun getViewType(): Int
    fun getUnique(): Any
}