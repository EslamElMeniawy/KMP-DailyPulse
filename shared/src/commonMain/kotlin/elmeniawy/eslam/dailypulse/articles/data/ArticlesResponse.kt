package elmeniawy.eslam.dailypulse.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ArticlesResponse
 *
 * Created by Eslam El-Meniawy on 20-Jul-2025 at 3:03 PM.
 */
@Serializable
data class ArticlesResponse(
    @SerialName("status")
    val status: String?,
    @SerialName("totalResults")
    val totalResults: Int?,
    @SerialName("articles")
    val articles: List<ArticleRaw>?,
)