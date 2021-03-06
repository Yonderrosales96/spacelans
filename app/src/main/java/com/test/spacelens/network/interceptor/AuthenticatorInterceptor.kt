package com.test.spacelens.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthenticatorInterceptor(val token : String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()

        val builder = original.newBuilder()
            .header("Authorization",token)

        val request = builder.build()
        return chain.proceed(request)

    }

}