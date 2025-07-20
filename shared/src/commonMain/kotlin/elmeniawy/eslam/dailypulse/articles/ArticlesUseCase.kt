@file:OptIn(ExperimentalTime::class)

package elmeniawy.eslam.dailypulse.articles

import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

/**
 * ArticlesUseCase
 *
 * Created by Eslam El-Meniawy on 20-Jul-2025 at 3:41 PM.
 */
class ArticlesUseCase(private val _service: ArticlesService) {
    suspend fun getArticles(): List<Article>? {
        val articlesRaw = _service.fetchArticles()
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>?): List<Article> = when (articlesRaw) {
        null -> emptyList()
        else -> mapNotNullArticles(articlesRaw)
    }

    private fun mapNotNullArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map {
        Article(
            title = it.title,
            des = it.desc,
            date = getDaysAgoString(it.date),
            imageUrl = it.imageUrl ?: "https://placehold.co/600x400"
        )
    }

    private fun getDaysAgoString(date: String?): String? {
        if (date.isNullOrBlank()) {
            return null
        }

        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())

        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )

        val positiveDays = abs(days)

        return when {
            positiveDays > 1 -> "$positiveDays days ago"
            positiveDays == 1 -> "Yesterday"
            else -> "Today"
        }
    }
}