package com.certified.githubreposearcch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.certified.githubreposearcch.data.model.Repo
import com.certified.githubreposearcch.data.model.RepoKeys

@Database(entities = [RepoKeys::class, Repo::class], version = 1, exportSchema = false)
abstract class GitHubDatabase : RoomDatabase() {
    abstract fun remoteKeysDao(): RemoteKeysDao
    abstract fun reposDao(): ReposDao
}