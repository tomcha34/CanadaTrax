package com.android.canadatrax

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface Api {


    @GET("summary")
    fun getSummary(): Call<CovidResponse>

}