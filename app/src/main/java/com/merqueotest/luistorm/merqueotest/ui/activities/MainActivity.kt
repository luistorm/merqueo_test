package com.merqueotest.luistorm.merqueotest.ui.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.RelativeLayout
import com.merqueotest.luistorm.merqueotest.R
import com.merqueotest.luistorm.merqueotest.ui.models.Movie
import com.merqueotest.luistorm.merqueotest.ui.models.MoviesAdapter
import com.merqueotest.luistorm.merqueotest.ui.network.NetworkApis
import com.merqueotest.luistorm.merqueotest.ui.viewmodels.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dialog: Dialog
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setListeners()
        loadMoviesInfo()
    }

    private fun loadMoviesInfo() {
        showLoader()
        mainViewModel.getPopularMovies()
    }

    @SuppressLint("CheckResult")
    private fun setListeners() {
        mainViewModel.notifyPopularMoviesSubject
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::drawMovies, Throwable::printStackTrace)
    }

    private fun drawMovies(movies: List<Movie>) {
        moviesRecyclerView.adapter = MoviesAdapter(movies)
        moviesRecyclerView
            .layoutManager = LinearLayoutManager(this)
        hideLoader()
    }

    private fun showLoader() {
        dialog = Dialog(this)
        dialog.setContentView(R.layout.loader_dialog)
        dialog.setCancelable(false)
        dialog.window!!.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT)
        dialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.show()
    }

    private fun hideLoader() {
        dialog.cancel()
    }

}
