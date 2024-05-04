package com.dicoding.asclepius.data.response

import com.google.gson.annotations.SerializedName

data class ArtikelResponse(

    @field:SerializedName("articles")
    val articles: List<Article>,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("totalResults")
    val totalResults: Int
)

data class Article(
    @field:SerializedName("author")
    val author: String,
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("description")
    val description: String,
    @field:SerializedName("publishedAt")
    val publishedAt: String,
    @field:SerializedName("source")
    val source: Source,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("url")
    val url: String,
    @field:SerializedName("urlToImage")
    val urlToImage: String
)

data class Source(
    @field:SerializedName("name")
    val id: String,
    @field:SerializedName("id")
    val name: String
)