package com.jmonzon.popcorn.retrofit

import com.jmonzon.popcorn.common.Constantes
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TheMovieDBClient {
    private val theMovieDBService: TheMovieDBService
    private val retrofit: Retrofit

    companion object {
        var instance: TheMovieDBClient? = null
            get() {
                if (field == null) {
                    instance = TheMovieDBClient()
                }
                return field
            }
    }

    init {
        //Includes interceptor
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(TheMovieDBInterceptor())

        val client = okHttpClientBuilder.build()

        //Build retrofit client
        retrofit = Retrofit.Builder()
            .baseUrl(Constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        //Instance retrofit service from retrofit´s object
        theMovieDBService = retrofit.create(TheMovieDBService::class.java)
    }

    fun getTheMovieDBService() = theMovieDBService
}