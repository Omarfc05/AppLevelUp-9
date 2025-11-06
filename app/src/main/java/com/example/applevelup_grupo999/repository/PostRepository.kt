package com.example.applevelup_grupo999.repository

import com.example.applevelup_grupo999.data.model.Post
import com.example.applevelup_grupo999.data.remote.RetrofitInstance

// Este repositorio se encarga de acceder a los datos usando Retrofit
class PostRepository {

    // Función que obtiene los posts desde la API
    suspend fun getPosts(): List<Post> {
        return RetrofitInstance.api.getPosts()
    }
}