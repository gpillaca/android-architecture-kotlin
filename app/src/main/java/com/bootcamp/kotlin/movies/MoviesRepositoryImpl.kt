package com.bootcamp.kotlin.movies

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesRepositoryImpl : MoviesRepository {
    override suspend fun popularMovies(): List<Movie> {
        val api = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .run { create(Movies::class.java) }

        val movies = api.popularMovies(
            apiKey = "5de961ca47ac20a3689205becc3c3b20",
            page = "1",
            language = "en-US"
        )

        return movies.results
    }
}