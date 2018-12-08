package com.merqueotest.luistorm.merqueotest.ui.network.responses

import com.google.gson.annotations.SerializedName
import com.merqueotest.luistorm.merqueotest.ui.models.Movie

class PopularMoviesResponse {

    @SerializedName("results")
    val results: List<Movie> = listOf()

}