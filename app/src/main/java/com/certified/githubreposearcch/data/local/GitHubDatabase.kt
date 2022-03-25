package com.certified.githubreposearcch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.certified.githubreposearcch.data.model.RepoKeys

@Database(entities = [RepoKeys::class], version = 1)
abstract class GitHubDatabase : RoomDatabase() {
    abstract fun remoteKeysDao(): RemoteKeysDao
}