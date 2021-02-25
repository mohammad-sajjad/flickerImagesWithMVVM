package com.example.flickerphotossearexample.model

import androidx.recyclerview.widget.RecyclerView
import com.example.flickerphotossearexample.common.CardConstants
import com.example.flickerphotossearexample.core.RecyclerViewListItem


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */
data class ImageListItems(
    val imageUrl: String,
    val name: String
) : RecyclerViewListItem
     {
    override fun getViewType() = CardConstants.IMAGES_ITEM_ADAPTER

    override fun getUnique() = this
}

