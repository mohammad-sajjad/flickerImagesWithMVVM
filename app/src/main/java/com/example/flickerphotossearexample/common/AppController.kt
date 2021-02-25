package com.example.flickerphotossearexample.common

import android.content.Context
import java.lang.ref.WeakReference

//class AppController : AppControllerContract {
//
//    companion object {
//        private var INSTANCE: AppController? = null
//        private var context: Context? = null
//        private lateinit var appVersion: String
//        private var appVersionCode: Int? = null
//        private var appPackageName: String = ""
//        private var baseUrl: String = "https://www.flickr.com/services/rest/"
//
//        fun init(context: Context, baseUrl: String): AppController? {
//            Companion.context = context
//            Companion.baseUrl = baseUrl
//            INSTANCE =
//                AppController()
//            return INSTANCE
//        }
//
//        fun get(): AppController = INSTANCE
//            ?: throw AppContextGoneException()
//    }
//
//
//    override fun getProperContext(): Context {
//        val localContext = App().appContext
//        return localContext ?: throw AppContextGoneException()
//    }
//
//    override fun getBaseURL() = baseUrl
//
//}