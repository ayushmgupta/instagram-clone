package com.amg.libimgur

import com.amg.libimgur.apis.ImgurAPIv3
import com.amg.libimgur.converters.EnumConvertryFactory
import com.mocklets.pluto.PlutoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    private const val API_KEY = "9838adb9045db92"

    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(PlutoInterceptor())
            .addInterceptor {
                val request = it.request().newBuilder()
                    .addHeader("Authorization","Client-ID $API_KEY")
                    .build()
                it.proceed(request)

            }
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(EnumConvertryFactory())
            .baseUrl("https://api.imgur.com/3/").build()
    }

    val api: ImgurAPIv3 by lazy {
        retrofit.create(ImgurAPIv3::class.java)
    }

}