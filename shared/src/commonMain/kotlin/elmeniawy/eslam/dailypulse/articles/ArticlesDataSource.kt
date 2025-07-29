package elmeniawy.eslam.dailypulse.articles

import elmeniawy.eslam.dailypulse.db.DailyPulseDatabase

/**
 * ArticlesDataSource
 *
 * Created by Eslam El-Meniawy on 29-Jul-2025 at 3:43 PM.
 */
class ArticlesDataSource(private val _database: DailyPulseDatabase) {
    fun getAllArticles(): List<ArticleRaw> =
        _database.dailyPulseDatabaseQueries.selectAllArticles(::mapToArticlesRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        _database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    fun clearArticles() = _database.dailyPulseDatabaseQueries.removeAllArticles()

    private fun mapToArticlesRaw(
        title: String?,
        des: String?,
        date: String?,
        imageUrl: String?
    ): ArticleRaw =
        ArticleRaw(title, des, date, imageUrl)

    private fun insertArticle(articleRaw: ArticleRaw) {
        _database.dailyPulseDatabaseQueries.insertArticle(
            articleRaw.title,
            articleRaw.desc,
            articleRaw.date,
            articleRaw.imageUrl
        )
    }
}