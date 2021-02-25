package com.example.flickerphotossearexample.common


sealed class DataFetchState {
    object Loading: DataFetchState()
    object Success: DataFetchState()
    class Error(val error: StandardError): DataFetchState()
}