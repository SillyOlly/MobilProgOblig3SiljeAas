package com.example.oblig3fotoalbummobilprog22aas.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"


/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    /**
     * Returns a Coroutine [List] of [User] which can be fetched in a Coroutine scope.
     * The @GET annotation indicates that the  endpoint will be requested with the GET
     * HTTP method
     */
    @GET("users")
    suspend fun getUsers(): List<Users>

//    @GET("users/{id}/albums")
//    suspend fun getAlbums(@Path("id") userId: Long): List<Album>
//
//    @GET("albums/{albumId}/photos")
//    suspend fun getAlbumPhotos(@Path("albumId") albumId: Long): List<Photo>
//
//    @GET("photos/{photoId}")
//    suspend fun getSelectedPhoto(@Path("photoId") photoId: Long): Photo

//    @DELETE("photos/{photoId}")
//    @Headers("User-Agent: android")
//    suspend fun deleteSelectedPhoto(@Query("photoId") photoId: Long): Response<ResponseBody>
}

object TestApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}