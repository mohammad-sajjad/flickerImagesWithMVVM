package com.example.flickerphotossearexample.remote

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {


    var retrofit: Retrofit? = null


    private fun getRetrofitClient(): Retrofit? {
        if (retrofit == null) {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


            val gson = GsonBuilder()
                .setLenient()
                .create()

            retrofit = Retrofit.Builder()
                .baseUrl("https://www.flickr.com/services/rest/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()


        }
        return retrofit
    }

    fun createServiceContract(): ApiController? {
        return getRetrofitClient()?.create(ApiController::class.java)
    }
}