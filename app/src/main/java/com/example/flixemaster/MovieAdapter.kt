package com.example.flixemaster

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


private const val TAG="MovieAdapter"
class MovieAdapter(private val context: Context, private val movies: List<Movie>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(context).inflate(R.layout.iteim_movies,parent,false)
      //  Log.i(TAG,"onCreateViewHolder")
        return ViewHolder(view)
     }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie=movies[position]
        //Log.i(TAG,"onBindViewHolder")
        holder.bind(movie)
    }

    override fun getItemCount()=movies.size
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val toTitle = itemView.findViewById<TextView>(R.id.TVtitle)
        private val toPoster = itemView.findViewById<ImageView>(R.id.TVPoster)
        private val toOverview = itemView.findViewById<TextView>(R.id.TvOverview)
        fun bind(movie: Movie) {
            toTitle.text = movie.title
            toOverview.text = movie.overView

            Glide.with(context).load(movie.postImageUrl).into(toPoster)

        }
   }
}