package com.example.flickerphotossearexample.view

import android.view.ViewGroup
import com.example.flickerphotossearexample.core.BaseDelegate
import com.example.flickerphotossearexample.core.BaseViewHolder


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */
class ImagesListDelegate(private val listener: ImagesListViewHolder.ImageItemClickListener) : BaseDelegate() {

    override fun onCreateViewHolder(parent: ViewGroup) = ImagesListViewHolder(parent, listener)
}