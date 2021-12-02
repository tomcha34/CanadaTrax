package com.android.canadatrax

import com.google.gson.annotations.SerializedName
import kotlin.collections.ArrayList

class CovidData{
    @SerializedName("latest_date")
    var newDate = ""

    @SerializedName("change_cases")
    var newCases = ""

    @SerializedName("change_fatalities")
    var newDeaths = ""

    @SerializedName("total_cases")
    var totalCases = ""

    @SerializedName("total_fatalities")
    var totalDeaths = ""

    @SerializedName("total_recoveries")
    var totalRecoveries = ""



}

class CovidResponse{
    @SerializedName("data")
    var data = ArrayList<CovidData>()
}
