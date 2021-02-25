package com.example.flickerphotossearexample.adapter

import com.example.flickerphotossearexample.common.CardConstants
import com.example.flickerphotossearexample.core.BaseAdapter
import com.example.flickerphotossearexample.view.ImagesListDelegate


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */
class ImageListAdapter: BaseAdapter() {

    init {
        initDelegates()
    }

    override fun initDelegates() {
        delegates[CardConstants.IMAGES_ITEM_ADAPTER] = ImagesListDelegate()
    }
}