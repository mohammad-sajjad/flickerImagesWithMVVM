package com.example.flickerphotossearexample.core


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */
abstract class BaseDelegate : DelegateInterface {

    override fun onBindViewHolder(holder: BaseViewHolder, item: RecyclerViewListItem) {
        holder.bindView(item)
    }
}