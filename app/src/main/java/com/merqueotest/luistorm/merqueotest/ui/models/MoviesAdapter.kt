package com.merqueotest.luistorm.merqueotest.ui.models

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.merqueotest.luistorm.merqueotest.BuildConfig
import com.merqueotest.luistorm.merqueotest.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item_view.view.*

class MoviesAdapter(private var movies : List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        this.context = viewGroup.context
        val inflater = LayoutInflater.from(context)
        val accountView = inflater.inflate(R.layout.movie_item_view, viewGroup, false)
        return ViewHolder(accountView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        val movie = movies[p1]
        viewHolder.itemView.movieTitleTextView.text = movie.title
        viewHolder.itemView.movieVoteAverageTextView.text = movie.vote_average.toString()
        Picasso.get().load(BuildConfig.BASE_IMAGE_URL + movie.poster_path).into(viewHolder.itemView.moviePosterImageView)
        viewHolder.itemView.movieDescriptionTextView.text = movie.overview
    }
}