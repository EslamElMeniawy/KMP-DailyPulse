package elmeniawy.eslam.dailypulse.articles

import elmeniawy.eslam.dailypulse.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

/**
 * ArticlesViewModel
 *
 * Created by Eslam El-Meniawy on 15-Jul-2025 at 4:41 PM.
 */
class ArticlesViewModel : BaseViewModel() {
    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    private val _useCase: ArticlesUseCase

    init {
        val httpClient = HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }

        val service = ArticlesService(httpClient)
        _useCase = ArticlesUseCase(service)

        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            val fetchedArticle = _useCase.getArticles()
            _articlesState.emit(ArticlesState(articles = fetchedArticle))
        }
    }
}