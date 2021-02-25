package com.example.flickerphotossearexample.remote

import com.example.flickerphotossearexample.model.SearchImagesApiModel
import retrofit2.Call
import retrofit2.http.*

interface ApiController {

    @GET
    fun getSearchImages(
        @Url url: String,
        @Query("method") method: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String,
        @Query("tags") tag: String,
        @Query("per_page") perPage: String,
        @Query("page") page: String,
        @Query("extras") extra: String,
        @Query("nojsoncallback=1") callback: String

    ): Call<SearchImagesApiModel>


}