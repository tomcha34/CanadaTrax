package com.android.canadatrax.network

import okhttp3.Request

class NetworkClient {

    // a function to make an object instance of a network request.
    fun get(): Request {
        val request = Request.Builder()
            //The data location
            .url("https://api.covid19tracker.ca/summary/split")
            //a get request
            .get()
            //build the request
            .build()
        return request
    }
}