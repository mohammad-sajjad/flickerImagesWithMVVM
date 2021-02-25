package com.example.flickerphotossearexample.remote

import com.example.flickerphotossearexample.common.StandardError

interface ApiResponseCallBack<T> {
    fun onSuccess(response: T)
    fun onFailure(standardError: StandardError)
}