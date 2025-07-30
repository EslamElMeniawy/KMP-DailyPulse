package elmeniawy.eslam.dailypulse.articles

import elmeniawy.eslam.dailypulse.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ArticlesViewModel
 *
 * Created by Eslam El-Meniawy on 15-Jul-2025 at 4:41 PM.
 */
class ArticlesViewModel(private val _useCase: ArticlesUseCase) : BaseViewModel() {
    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.emit(
                ArticlesState(
                    loading = true,
                    articles = _articlesState.value.articles
                )
            )
            
            val fetchedArticle = _useCase.getArticles(forceFetch)
            _articlesState.emit(ArticlesState(articles = fetchedArticle))
        }
    }
}