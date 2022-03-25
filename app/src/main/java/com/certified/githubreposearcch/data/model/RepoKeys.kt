package com.certified.githubreposearcch.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "github_repo_search_remote_keys_table")
data class RepoKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevKey: Int?,
    val nextKey: Int?
)