package com.merqueotest.luistorm.merqueotest.ui.network

import com.merqueotest.luistorm.merqueotest.ui.network.responses.PopularMoviesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("/popular")
    fun getPopularMovies(@Query("api_key") api_key: String, @Query("language") language: String = "en-US"): Single<PopularMoviesResponse>

}