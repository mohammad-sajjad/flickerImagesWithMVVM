package com.example.flickerphotossearexample.common

/**
 * created by Mohammad Sajjad
 * on 29-01-2021 at 10:53
 * mohammadsajjad679@gmail.com
 */
class NoInternetConnectionException : Exception() {
    override val message: String
        get() = "No Internet Connection"
}
