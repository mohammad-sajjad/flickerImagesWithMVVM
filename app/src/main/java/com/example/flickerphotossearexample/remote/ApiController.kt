package com.example.flickerphotossearexample.remote

import com.example.flickerphotossearexample.model.SearchImagesApiModel
import retrofit2.Call
import retrofit2.http.*

interface ApiController {

    @FormUrlEncoded
    @POST
    fun getSearchImages(
            @Url url: String,
            @Field("method") method: String,
            @Field("api_key") apiKey: String,
            @Field("format") format: String,
            @Field("tags") tag: String,
            @Field("per_page") perPage: String,
            @Field("page") page: String,
            @Field("extras") extra: String,
            @Field("nojsoncallback") callback: String

    ): Call<SearchImagesApiModel>


}