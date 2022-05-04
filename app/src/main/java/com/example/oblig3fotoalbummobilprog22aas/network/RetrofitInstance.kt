package com.example.oblig3fotoalbummobilprog22aas.network

import android.telecom.PhoneAccount.builder
import com.example.oblig3fotoalbummobilprog22aas.network.FotoalbumApi
//import com.example.oblig3fotoalbummobilprog22aas.network.moshi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.stream.DoubleStream.builder

object RetrofitInstance {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiService::class.java)
    }

}