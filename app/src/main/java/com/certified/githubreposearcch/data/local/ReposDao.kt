package com.certified.githubreposearcch.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.certified.githubreposearcch.data.model.Repo

@Dao
interface ReposDao {

    @Query("SELECT * FROM github_search_repo_table")
    fun getAllRepos(): PagingSource<Int, Repo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRepos(repos: List<Repo>)

    @Query("DELETE FROM github_search_repo_table")
    suspend fun deleteAllRepos()
}