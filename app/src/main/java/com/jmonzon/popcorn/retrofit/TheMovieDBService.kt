package com.jmonzon.popcorn.retrofit

import com.jmonzon.popcorn.retrofit.models.PopularMoviesResponse
import retrofit2.Call
import retrofit2.http.GET

interface TheMovieDBService {

    @GET("movie/popular")
    fun getPopularMovies(): Call<PopularMoviesResponse>
}