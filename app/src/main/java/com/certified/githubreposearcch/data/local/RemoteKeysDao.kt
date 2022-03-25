package com.certified.githubreposearcch.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.certified.githubreposearcch.data.model.RepoKeys

@Dao
interface RemoteKeysDao {

    @Query("SELECT * FROM github_repo_search_remote_keys_table WHERE id =:id")
    suspend fun getRemoteKeys(id: String): RepoKeys

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(remoteKeys: List<RepoKeys>)

    @Query("DELETE FROM github_repo_search_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}