package com.android.canadatrax

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "CovidActivity"
lateinit var newCasesTextView: TextView
lateinit var totalCasesTextView: TextView

class CovidActivity : AppCompatActivity() {

    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)
        newCasesTextView = findViewById(R.id.newCasesTextView)
        totalCasesTextView = findViewById(R.id.totalCasesTextView)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.covid19tracker.ca/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
        getSummary()


    }

    private fun getSummary() {
        val call = api.getSplit()
        call.enqueue(object: Callback<CovidResponse> {
            override fun onResponse(
                call: Call<CovidResponse>,
                response: retrofit2.Response<CovidResponse>
            ) {
                val covidData = response.body()!!

                for(covid in covidData.data){

                    newCasesTextView.text = "New cases in Canada today: " + covid.newCases
                    totalCasesTextView.text = "Total cases in Canada: " + covid.totalCases
                }


                }

            override fun onFailure(call: Call<CovidResponse>, t: Throwable) {
                newCasesTextView.text = t.message
            }


        })
    }

}