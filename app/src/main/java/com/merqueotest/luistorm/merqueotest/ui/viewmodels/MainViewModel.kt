package com.merqueotest.luistorm.merqueotest.ui.viewmodels

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.merqueotest.luistorm.merqueotest.BuildConfig
import com.merqueotest.luistorm.merqueotest.ui.models.Movie
import com.merqueotest.luistorm.merqueotest.ui.network.NetworkApis
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

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

}