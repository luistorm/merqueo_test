package com.merqueotest.luistorm.merqueotest.ui.network

class NetworkApis {

    companion object {

        val moviesApi = ApiClient.getClient()!!.create(MoviesApi::class.java)

    }

}