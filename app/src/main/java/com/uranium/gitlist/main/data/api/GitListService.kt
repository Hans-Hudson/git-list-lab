package com.uranium.gitlist.main.data.api

import com.uranium.gitlist.main.data.model.FetchRepositoriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GitListService {

    @GET("search/repositories")
    suspend fun fetchRepositories(
        @Query("q") query: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int,
    ): FetchRepositoriesResponse
}