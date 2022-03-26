package com.certified.githubreposearcch.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import com.certified.githubreposearcch.data.model.Repo
import com.certified.githubreposearcch.utils.Extensions.openBrowser

@Composable
fun ListContent(items: LazyPagingItems<Repo>) {
    val context = LocalContext.current
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
            repo?.let {
                ItemRepository(repo = repo, onClick = { context.openBrowser(repo.url) })
            }
        }
    }
}