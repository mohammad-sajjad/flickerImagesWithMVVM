package com.example.flickerphotossearexample

import com.example.flickerphotossearexample.common.DataFetchState
import com.example.flickerphotossearexample.common.StandardError
import com.example.flickerphotossearexample.common.StateMachine
import com.example.flickerphotossearexample.core.BaseViewModel
import com.example.flickerphotossearexample.core.RecyclerViewListItem
import com.example.flickerphotossearexample.model.SearchImagesApiModel
import com.example.flickerphotossearexample.model.SearchImagesRequestParams
import com.example.flickerphotossearexample.remote.ApiResponseCallBack

class SearchImagesViewModel : BaseViewModel() {

    private val repository = SearchImagesRepository(SearchImagesApiDataContract.get())
    val items = mutableListOf<RecyclerViewListItem>()


    fun getImages(stateMachine: StateMachine, query: String, page: Int = 0) {
        stateMachine.postValue(DataFetchState.Loading)

        if (query.isEmpty()) {
            stateMachine.postValue(DataFetchState.Error(StandardError("field can not be empty")))
            return
        }
        val params = SearchImagesRequestParams("flickr.photos.search", "3189212285dcb4cf5b2f044edcb0544e", "json", query, "10", page.toString(), "url_l", "1")

        repository.getImages(params, object : ApiResponseCallBack<SearchImagesApiModel> {
            override fun onSuccess(response: SearchImagesApiModel) {
                if (response.photos.photo.isNotEmpty()) {
                    ImagesTransformer.getListItems(response.photos.photo).map { items.add(it) }
                    stateMachine.postValue(DataFetchState.Success)
                }
                else {
                    stateMachine.postValue(DataFetchState.Error(StandardError(displayError = "Something is wrong")))
                }
            }

            override fun onFailure(standardError: StandardError) {
                stateMachine.postValue(DataFetchState.Error(standardError))
            }

        })
    }
}