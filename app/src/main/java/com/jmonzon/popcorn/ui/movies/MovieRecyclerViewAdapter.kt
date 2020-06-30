package com.jmonzon.popcorn.ui.movies

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.jmonzon.popcorn.R
import com.jmonzon.popcorn.common.Constantes
import com.jmonzon.popcorn.retrofit.models.Movie
import kotlinx.android.synthetic.main.fragment_movie_list.view.*

class MovieRecyclerViewAdapter() : RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    private val mOnclickListener: View.OnClickListener
    private var movies: List<Movie> = ArrayList()

    init {
        mOnclickListener = View.OnClickListener { v ->
            val item = v.tag as Movie
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = movies[position]
        holder.textViewTittle.text = item.title
        holder.textViewRating.text = item.vote_average.toString()
        holder.imageViewPhoto.load(Constantes.IMAGE_BASE_URL + item.poster_path){
            crossfade(true)
            placeholder(R.drawable.ic_local_movies_black_24dp)
            transformations(CircleCropTransformation())
        }

    }

    override fun getItemCount(): Int = movies.size

    fun setData(popularMovies: List<Movie>?) {
        movies = popularMovies!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewPhoto: ImageView = view.imageViewPhoto
        var textViewTittle: TextView = view.textViewTittle
        val textViewRating: TextView = view.textViewRating
    }
}