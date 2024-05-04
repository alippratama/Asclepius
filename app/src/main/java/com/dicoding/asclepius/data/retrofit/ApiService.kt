package com.dicoding.asclepius.data.retrofit

import com.dicoding.asclepius.data.response.ArtikelResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("top-headlines?q=cancer&category=health&language=en&apiKey=aa65e254af9a41eb9c35a7331469cc92")
    fun getArticle(): Call<ArtikelResponse>
}