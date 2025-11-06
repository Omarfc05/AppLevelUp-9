package com.example.applevelup_grupo999.data.remote


import com.example.applevelup_grupo999.data.model.Post
import retrofit2.http.GET

// Esta interfaz define los endpoints HTTP
interface ApiService {

    // Define una solicitud GET al endpoint /posts
    @GET(value = "/posts")
    suspend fun getPosts(): List<Post>
}