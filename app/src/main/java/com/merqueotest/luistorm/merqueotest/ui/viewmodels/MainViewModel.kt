package com.merqueotest.luistorm.merqueotest.ui.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import com.merqueotest.luistorm.merqueotest.BuildConfig
import com.merqueotest.luistorm.merqueotest.ui.models.Movie
import com.merqueotest.luistorm.merqueotest.ui.network.NetworkApis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import android.net.NetworkInfo
import android.net.ConnectivityManager



class MainViewModel(application: Application) : AndroidViewModel(application) {

    val notifyPopularMoviesSubject: Subject<List<Movie>> = PublishSubject.create()

    @SuppressLint("CheckResult")
    fun getPopularMovies() {
        NetworkApis.moviesApi.getPopularMovies(BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                notifyPopularMoviesSubject.onNext(it.results)
            }, Throwable::printStackTrace)
    }

    fun hasInternetConnection(context: Context) : Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return connectivityManager!!.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).state == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(
            ConnectivityManager.TYPE_WIFI
        ).state == NetworkInfo.State.CONNECTED
    }

}