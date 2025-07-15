package elmeniawy.eslam.dailypulse.articles

import elmeniawy.eslam.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ArticlesViewModel
 *
 * Created by Eslam El-Meniawy on 15-Jul-2025 at 4:41 PM.
 */
class ArticlesViewModel : BaseViewModel() {
    private val _articlesState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState())

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(500)
            _articlesState.emit(ArticlesState())
        }
    }
}