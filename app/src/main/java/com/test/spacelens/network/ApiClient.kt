package com.test.spacelens.network

import com.test.spacelens.BuildConfig
import com.test.spacelens.network.interceptor.AuthenticatorInterceptor
import okhttp3.Authenticator
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {

        operator fun invoke() : Endpoints{

            val auth = Credentials.basic(BuildConfig.USER,BuildConfig.PASSWORD)
            val interceptor = AuthenticatorInterceptor(auth)
            val httpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

            return Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BuildConfig.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Endpoints::class.java)

        }
    }

}