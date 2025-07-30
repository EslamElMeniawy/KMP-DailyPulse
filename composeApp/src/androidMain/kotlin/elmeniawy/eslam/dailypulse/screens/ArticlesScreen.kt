@file:OptIn(ExperimentalMaterial3Api::class)

package elmeniawy.eslam.dailypulse.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import elmeniawy.eslam.dailypulse.TAG
import elmeniawy.eslam.dailypulse.articles.domain.Article
import elmeniawy.eslam.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * ArticlesScreen
 *
 * Created by Eslam El-Meniawy on 16-Jul-2025 at 2:08 PM.
 */

@Composable
fun ArticlesScreen(
    onSystemInfoButtonClick: () -> Unit,
    articlesViewModel: ArticlesViewModel = koinViewModel()
) {
    val articlesState = articlesViewModel.articlesState.collectAsState()

    Column {
        AppBar(onSystemInfoButtonClick)

        if (!articlesState.value.error.isNullOrBlank()) {
            ErrorMessage(articlesState.value.error!!)
        } else {
            ArticlesListView(articlesViewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(onSystemInfoButtonClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
            IconButton(onClick = onSystemInfoButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "System Info Button"
                )
            }
        }
    )
}

@Composable
private fun ArticlesListView(viewModel: ArticlesViewModel) {
    val articlesState = viewModel.articlesState.collectAsState()
    val articles = articlesState.value.articles ?: listOf()
    val isRefreshing = articlesState.value.loading
    val pullRefreshState = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = { viewModel.getArticles(true) },
        state = pullRefreshState,
        modifier = Modifier.fillMaxSize()
    )
    {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(articles) { article ->
                ArticleItemView(article = article)
            }
        }
    }
}

@Composable
private fun ArticleItemView(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = article.imageUrl,
            contentDescription = null,
            onLoading = { Log.d(TAG, "Loading") },
            onSuccess = { Log.d(TAG, "Success") },
            onError = { error -> Log.d(TAG, "Error", error.result.throwable) }
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.title ?: "",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.des ?: "")
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.date ?: "",
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Composable
private fun ErrorMessage(message: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = message,
            style = TextStyle(fontSize = 28.sp, textAlign = TextAlign.Center),
        )
    }
}