package com.jmonzon.popcorn.retrofit.models

data class PopularMoviesResponse(
    val page: Int,
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)