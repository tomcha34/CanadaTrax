package com.android.canadatrax

import com.google.gson.annotations.SerializedName
import kotlin.collections.ArrayList

class CovidData{
    @SerializedName("change_cases")
    var newCases = ""

    @SerializedName("total_cases")
    var totalCases = ""

}

class CovidResponse{
    @SerializedName("data")
    var data = ArrayList<CovidData>()
}
