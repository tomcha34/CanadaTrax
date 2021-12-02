package com.android.canadatrax

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "CovidActivity"
lateinit var valueDate: TextView
lateinit var valueNewCases: TextView
lateinit var valueNewDeaths: TextView
lateinit var valueTotalCases: TextView
lateinit var valueTotalDeaths: TextView
lateinit var valueTotalRecoveries: TextView

class CovidActivity : AppCompatActivity() {

    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)
        valueDate = findViewById(R.id.valueDate)
        valueNewCases = findViewById(R.id.valueNewCases)
        valueNewDeaths = findViewById(R.id.valueNewDeaths)
        valueTotalCases = findViewById(R.id.valueTotalCases)
        valueTotalDeaths = findViewById(R.id.valueTotalDeaths)
        valueTotalRecoveries = findViewById(R.id.valueTotalRecoveries)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.covid19tracker.ca/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
        getSummary()


    }

    private fun getSummary() {
        val call = api.getSummary()
        call.enqueue(object: Callback<CovidResponse> {
            override fun onResponse(
                call: Call<CovidResponse>,
                response: retrofit2.Response<CovidResponse>
            ) {
                val covidData = response.body()!!

                for(covid in covidData.data){

                    valueDate.text = covid.newDate
                    valueNewCases.text = covid.newCases
                    valueNewDeaths.text = covid.newDeaths
                    valueTotalCases.text = covid.totalCases
                    valueTotalDeaths.text = covid.totalDeaths
                    valueTotalRecoveries.text = covid.totalRecoveries

                }


                }

            override fun onFailure(call: Call<CovidResponse>, t: Throwable) {
                valueDate.text = t.message
            }


        })
    }

}