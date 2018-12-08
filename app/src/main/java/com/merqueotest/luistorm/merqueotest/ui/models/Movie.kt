package com.merqueotest.luistorm.merqueotest.ui.models

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("id")
    val id: Int = -1

    @SerializedName("vote_average")
    val vote_average: Double = -1.0

    @SerializedName("title")
    val title: String = ""

    @SerializedName("poster_path")
    val poster_path: String = ""

    @SerializedName("backdrop_path")
    val backdrop_path: String = ""

    @SerializedName("overview")
    val overview: String = ""

}