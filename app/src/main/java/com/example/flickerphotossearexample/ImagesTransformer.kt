package com.example.flickerphotossearexample

import com.example.flickerphotossearexample.model.ImageListItems
import com.example.flickerphotossearexample.model.SearchImagesApiModel


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */
object ImagesTransformer {


    fun getListItems(data: List<SearchImagesApiModel.Photos.Photo>): List<ImageListItems> {
        return data.map { ImageListItems(it.urlL ?: "" , it.title) }
    }

}