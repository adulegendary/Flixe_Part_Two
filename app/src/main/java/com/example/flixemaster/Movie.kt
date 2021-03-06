package com.example.flixemaster

import org.json.JSONArray

data class Movie(
    val movieId: Int,
    private val posterPath: String,
    val title: String,
    val overView: String,
        ){
    val postImageUrl=  "https://image.tmdb.org/t/p/w342/$posterPath"
    companion object{
        fun fromJsonArray(movieJasonArray: JSONArray): List<Movie> {
             val movies= mutableListOf<Movie>()
             for(i in 0 until movieJasonArray.length()){
                 val movieJson=movieJasonArray.getJSONObject(i)
                 movies.add(
                     Movie(
                        movieJson.getInt("id"),
                         movieJson.getString("poster_path"),
                         movieJson.getString("title"),
                         movieJson.getString("overview"),

                     )

                 )
             }

            return movies
        }
    }
}

