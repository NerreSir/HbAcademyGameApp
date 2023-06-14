package com.example.hbacademyapp.data

import com.example.hbacademyapp.util.Constants
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val apiKey = Constants.API_KEY
        val newUrl = original.url.newBuilder().addQueryParameter("key", apiKey).build()
        original = original.newBuilder().url(newUrl).build()
        return chain.proceed(original)
    }


}