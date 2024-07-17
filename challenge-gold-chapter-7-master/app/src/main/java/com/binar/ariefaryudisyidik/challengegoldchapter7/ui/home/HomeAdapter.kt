package com.binar.ariefaryudisyidik.challengegoldchapter7.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binar.ariefaryudisyidik.challengegoldchapter7.data.remote.response.Movie
import com.binar.ariefaryudisyidik.challengegoldchapter7.databinding.ItemMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class HomeAdapter(private val listMovie: List<Movie>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    companion object {
        const val posterBaseUrl = "https://image.tmdb.org/t/p/w500"
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }

    class ViewHolder(var binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieResponse = listMovie[position]
        val poster = posterBaseUrl + movieResponse.posterPath
        val title = movieResponse.title
        val releaseDate = movieResponse.releaseDate
        val averageRating = movieResponse.voteAverage.toString()

        Log.d("adapter", "onBindViewHolder: $poster")
        holder.binding.apply {
            Glide.with(holder.itemView.context).load(poster)
                .transition(DrawableTransitionOptions.withCrossFade()).into(ivPoster)
            tvTitle.text = title
            tvReleaseDate.text = releaseDate
            tvAverageRating.text = averageRating
            tvReadMore.setOnClickListener {
                onItemClickCallback.onItemClicked(listMovie[holder.adapterPosition])
            }
        }
    }

    override fun getItemCount() = listMovie.size
}