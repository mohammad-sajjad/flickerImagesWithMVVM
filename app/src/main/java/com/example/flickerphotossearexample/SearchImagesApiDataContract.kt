package com.example.flickerphotossearexample

import com.example.flickerphotossearexample.model.SearchImagesApiModel
import com.example.flickerphotossearexample.model.SearchImagesRequestParams
import com.example.flickerphotossearexample.remote.ApiResponseCallBack

interface SearchImagesApiDataContract {

    companion object {
        fun get(): SearchImagesApiDataContract = SearchImagesApiService()
    }

    fun getImages(params: SearchImagesRequestParams, responseCallBack: ApiResponseCallBack<SearchImagesApiModel>)
}