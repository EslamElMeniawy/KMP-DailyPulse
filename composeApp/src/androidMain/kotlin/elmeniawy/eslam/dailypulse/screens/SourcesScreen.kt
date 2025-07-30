@file:OptIn(ExperimentalMaterial3Api::class)

package elmeniawy.eslam.dailypulse.screens

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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
import elmeniawy.eslam.dailypulse.sources.domain.Source
import elmeniawy.eslam.dailypulse.sources.presentation.SourcesViewModel
import org.koin.androidx.compose.koinViewModel

/**
 * SourcesScreen
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 4:07 PM.
 */

@Composable
fun SourcesScreen(
    onBackButtonClick: () -> Unit,
    sourcesViewModel: SourcesViewModel = koinViewModel()
) {
    val sourcesState = sourcesViewModel.sourcesState.collectAsState()

    Column {
        Toolbar(onBackButtonClick)

        if (!sourcesState.value.error.isNullOrBlank()) {
            ErrorMessage(sourcesState.value.error!!)
        } else {
            SourcesListView(sourcesViewModel)
        }
    }
}

@Composable
private fun Toolbar(onBackButtonClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Sources") },
        navigationIcon = {
            IconButton(onClick = onBackButtonClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Button"
                )
            }
        }
    )
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

@Composable
private fun SourcesListView(viewModel: SourcesViewModel) {
    val sourcesState = viewModel.sourcesState.collectAsState()
    val sources = sourcesState.value.sources ?: listOf()
    val isRefreshing = sourcesState.value.loading
    val pullRefreshState = rememberPullToRefreshState()

    PullToRefreshBox(
        isRefreshing = isRefreshing,
        onRefresh = { viewModel.getSources(true) },
        state = pullRefreshState,
        modifier = Modifier.fillMaxSize()
    )
    {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(sources) { source ->
                SourceItemView(source = source)
            }
        }
    }
}

@Composable
private fun SourceItemView(source: Source) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = source.name ?: "",
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 22.sp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = source.description ?: "")
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = source.languageCountry ?: "",
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(modifier = Modifier.height(4.dp))
    }
}