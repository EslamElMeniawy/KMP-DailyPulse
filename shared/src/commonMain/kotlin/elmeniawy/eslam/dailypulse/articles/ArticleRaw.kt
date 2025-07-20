package elmeniawy.eslam.dailypulse.articles

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ArticleRaw
 *
 * Created by Eslam El-Meniawy on 20-Jul-2025 at 3:08 PM.
 */
@Serializable
data class ArticleRaw(
    @SerialName("title")
    val title: String?,
    @SerialName("description")
    val desc: String?,
    @SerialName("publishedAt")
    val date: String?,
    @SerialName("urlToImage")
    val imageUrl: String?,
)
