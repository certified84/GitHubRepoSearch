package com.certified.githubreposearcch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.certified.githubreposearcch.data.model.Repo

@Composable
fun ListContent(items: LazyPagingItems<Repo>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = items,
            key = { repo ->
                repo.id
            }
        ) { repo ->
            repo?.let { ItemRepository(repo = repo) }
        }
    }
}