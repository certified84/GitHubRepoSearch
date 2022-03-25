package com.certified.githubreposearcch.data.repository

import com.certified.githubreposearcch.data.network.GitHubService
import javax.inject.Inject

class GitHubRepository @Inject constructor(private val service: GitHubService) {

//    fun getSearchResultStream(query: String): Flow<PagingData<Repo>> {
//        Log.d("GithubRepository", "New query: $query")
//        return Pager(
//            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE, enablePlaceholders = false),
//            pagingSourceFactory = { GithubPagingSource(service, query) }
//        ).flow
//    }

    companion object {
        const val NETWORK_PAGE_SIZE = 30
    }
}