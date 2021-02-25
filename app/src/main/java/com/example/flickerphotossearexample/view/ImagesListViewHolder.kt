package com.example.flickerphotossearexample.view

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.flickerphotossearexample.R
import com.example.flickerphotossearexample.common.inflate
import com.example.flickerphotossearexample.core.BaseViewHolder
import com.example.flickerphotossearexample.core.RecyclerViewListItem
import com.example.flickerphotossearexample.model.ImageListItems


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */
class ImagesListViewHolder(parent: ViewGroup) : BaseViewHolder(parent.inflate(R.layout.images_list_item_layout)) {

    override fun bindView(item: RecyclerViewListItem) {
        item as ImageListItems

        val image = itemView.findViewById<View>(R.id.item_image) as ImageView
        val titleTv = itemView.findViewById<View>(R.id.item_name_tv) as TextView

        Glide.with(itemView.context).load(item.imageUrl).into(image)
        titleTv.text = item.name


    }
}