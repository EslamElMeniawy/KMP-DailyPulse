package elmeniawy.eslam.dailypulse.articles

/**
 * ArticlesRepository
 *
 * Created by Eslam El-Meniawy on 29-Jul-2025 at 3:55 PM.
 */
class ArticlesRepository(
    private val _dataSource: ArticlesDataSource,
    private val _service: ArticlesService
) {
    suspend fun getArticles(): List<ArticleRaw>? {
        val articlesDb = _dataSource.getAllArticles()

        if (articlesDb.isEmpty()) {
            val fetchedArticles = _service.fetchArticles()
            _dataSource.insertArticles(fetchedArticles)
            return fetchedArticles
        }

        return articlesDb
    }
}