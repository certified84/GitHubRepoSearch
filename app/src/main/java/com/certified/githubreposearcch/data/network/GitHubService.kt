package com.certified.githubreposearcch.data.network

import com.certified.githubreposearcch.data.model.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {
    @GET("search/repositories?sort=stars")
    suspend fun searchRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): RepoSearchResponse
}