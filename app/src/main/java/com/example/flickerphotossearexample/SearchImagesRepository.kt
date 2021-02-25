package com.example.flickerphotossearexample

import com.example.flickerphotossearexample.model.SearchImagesApiModel
import com.example.flickerphotossearexample.model.SearchImagesRequestParams
import com.example.flickerphotossearexample.remote.ApiResponseCallBack

class SearchImagesRepository(private val apiService: SearchImagesApiDataContract) {

    fun getImages(params: SearchImagesRequestParams, responseCallBack: ApiResponseCallBack<SearchImagesApiModel>) {
        apiService.getImages(params, responseCallBack)
    }
}