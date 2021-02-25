package com.example.flickerphotossearexample.core

import android.view.ViewGroup


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */

interface DelegateInterface {
    fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder
    fun onBindViewHolder(holder: BaseViewHolder, item: RecyclerViewListItem)
}