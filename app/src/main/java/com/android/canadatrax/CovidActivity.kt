package com.android.canadatrax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.canadatrax.network.NetworkClient
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response

private const val TAG = "CovidActivity"

class CovidActivity : AppCompatActivity() {

    //creating an instance of our NetworkClient class.
    private val networkClient = NetworkClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)
        getJson()


    }

    //a function to get network data on a background thread.
    private fun getJson() {
        //Our NetworkClient instance
        val request = networkClient.get()

        //a factory for network calls
        val client = OkHttpClient()
        //making a call on a background thread and handling the response.
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: java.io.IOException) {
                Log.e(TAG, "onFailure: Tommy it didn't work", )
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body!!.string()
                Log.w(TAG, body, )
            }

        })
    }
}