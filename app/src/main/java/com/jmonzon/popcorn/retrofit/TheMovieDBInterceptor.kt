package com.jmonzon.popcorn.retrofit

import com.jmonzon.popcorn.common.Constantes
import okhttp3.Interceptor
import okhttp3.Response

class TheMovieDBInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //Add params to recived URL (chain)
        val urlWithParams = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(Constantes.URL_PARAM_API_KEY, Constantes.API_KEY)
            .addQueryParameter(Constantes.URL_PARAM_LANGUAGE, Constantes.LANGUAGE_SPANISH_API)
            .build()

        var request = chain.request()
        request = request.newBuilder()
            .url(urlWithParams)
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()

        return chain.proceed(request)
    }
}