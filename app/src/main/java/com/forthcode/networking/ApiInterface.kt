package com.forthcode.networking


import com.forthcode.data.ForthCodePhotosItem
import retrofit2.http.GET


interface ApiInterface {
    @GET("/photos")
    suspend fun getPhotosList(): List<ForthCodePhotosItem>


}