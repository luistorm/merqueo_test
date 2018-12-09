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
import android.net.ConnectivityManager
import io.realm.Realm


class MainViewModel(application: Application) : AndroidViewModel(application) {

    val notifyPopularMoviesSubject: Subject<List<Movie>> = PublishSubject.create()
    private val realm = Realm.getDefaultInstance()

    fun getPopularMovies(contex: Context) {
        when(hasInternetConnection(contex)) {
            true -> callPopularMoviesService()
            false -> notifyPopularMoviesSubject.onNext(getMoviesFromDatabase())
        }
    }

    @SuppressLint("CheckResult")
    private fun callPopularMoviesService() {
        NetworkApis.moviesApi.getPopularMovies(BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                insertMoviesInDatabase(it.results)
                notifyPopularMoviesSubject.onNext(it.results)
            }, Throwable::printStackTrace)
    }

    private fun insertMoviesInDatabase(movies: List<Movie>) {
        movies.forEach {
            realm.beginTransaction()
            realm.insert(it)
            realm.commitTransaction()
        }
    }

    private fun getMoviesFromDatabase() = realm.where(Movie::class.java).findAll().toList()

    private fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return connectivityManager!!.activeNetworkInfo != null && connectivityManager.activeNetworkInfo.isConnected
    }

}