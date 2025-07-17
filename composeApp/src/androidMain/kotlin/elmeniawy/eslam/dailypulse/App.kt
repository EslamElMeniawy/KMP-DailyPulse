package elmeniawy.eslam.dailypulse

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import elmeniawy.eslam.dailypulse.articles.ArticlesViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(articlesViewModel: ArticlesViewModel) {
    MaterialTheme {
        AppScaffold(articlesViewModel)
    }
}