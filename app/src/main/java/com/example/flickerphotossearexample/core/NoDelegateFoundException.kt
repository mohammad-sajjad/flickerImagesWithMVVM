package com.example.flickerphotossearexample.core


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */
class NoDelegateFoundException(private val item: Int, private val errorClass: String) : Exception() {
    override val message: String?
        get() = "No delegate found for the view type : $item in $errorClass"
}