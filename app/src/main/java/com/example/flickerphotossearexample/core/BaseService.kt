package com.example.flickerphotossearexample.core

import android.util.Log
import com.example.flickerphotossearexample.common.NoInternetConnectionException
import com.example.flickerphotossearexample.common.StandardError
import com.example.flickerphotossearexample.model.SearchImagesApiModel
import com.example.flickerphotossearexample.remote.ApiResponseCallBack
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class BaseService {

    inline fun <reified T> makeRequest(call: Call<T>, responseCallBack: ApiResponseCallBack<T>) {

        call.enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>?, t: Throwable?) {
                if (t is NoInternetConnectionException) {
                    responseCallBack.onFailure(
                            StandardError(NoInternetConnectionException().message)
                    )
                } else {
                    responseCallBack.onFailure(StandardError(t?.message!!))
                }
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    Log.e("response", response.body().toString())
                    Log.e("response", response.toString())
                    responseCallBack.onSuccess(response.body())
                }
            }

        })
    }


}