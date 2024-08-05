package com.example.wallpaper.data.remote

import com.example.wallpaper.common.UtilsApi.API_KEY
import com.example.wallpaper.data.dto.UnsplashDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("search/photos")
    suspend fun fetchWallpaper(
        @Query("page") page: Int = 1,
        @Query("query") query: String = "natural",
        @Query("per_page") perPage: Int = 30,
    ): UnsplashDto

}