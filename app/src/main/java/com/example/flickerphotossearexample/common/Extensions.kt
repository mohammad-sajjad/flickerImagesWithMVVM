package com.example.flickerphotossearexample.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * Created by Mohammad sajjad on 24-02-2021.
 * mohammadsajjad679@gmail.com
 */

fun ViewGroup.inflate(resId: Int): View {
    return LayoutInflater.from(context).inflate(resId, this, false)
}
