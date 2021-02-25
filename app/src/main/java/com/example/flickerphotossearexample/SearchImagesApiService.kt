package com.example.flickerphotossearexample

import com.example.flickerphotossearexample.core.BaseService
import com.example.flickerphotossearexample.model.SearchImagesApiModel
import com.example.flickerphotossearexample.model.SearchImagesRequestParams
import com.example.flickerphotossearexample.remote.ApiResponseCallBack
import com.example.flickerphotossearexample.remote.RetrofitBuilder
import retrofit2.Call

class SearchImagesApiService : BaseService(), SearchImagesApiDataContract {

    override fun getImages(
        params: SearchImagesRequestParams,
        responseCallBack: ApiResponseCallBack<SearchImagesApiModel>
    ) {
        val call: Call<SearchImagesApiModel> =
            RetrofitBuilder.createServiceContract()?.getSearchImages("", "flickr.photos.search","3189212285dcb4cf5b2f044edcb0544e","json","Birds","20", "1", "url_l", "1")!!
        makeRequest(call, responseCallBack)

    }
}


// https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=3189212285dcb4cf5b2f044edcb0544e&tags=mountains&extras=url_l&per_page=5&page=1&format=json&nojsoncallback=1

//https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=3189212285dcb4cf5b2f044edcb0544e&format=json&tags=Birds&per_page=20&page=1&extras=url_l&nojsoncallback%3D1=1
