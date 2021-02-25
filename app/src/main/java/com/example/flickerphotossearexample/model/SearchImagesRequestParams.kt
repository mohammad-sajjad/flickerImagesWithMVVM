package com.example.flickerphotossearexample.model

class SearchImagesRequestParams (

    val method: String,
    val api_key: String,
    val format: String,
    val tags: String,
    val per_page: String,
    val page: String,
    val extras: String,
    val nojsoncallback: String
)