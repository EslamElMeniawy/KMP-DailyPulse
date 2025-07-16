package elmeniawy.eslam.dailypulse.articles

/**
 * ArticlesState
 *
 * Created by Eslam El-Meniawy on 15-Jul-2025 at 4:45 PM.
 */
data class ArticlesState(
    val articles: List<Article>? = null,
    val loading: Boolean = false,
    val error: String? = null
)