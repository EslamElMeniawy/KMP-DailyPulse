package elmeniawy.eslam.dailypulse.articles.data

import elmeniawy.eslam.dailypulse.BuildKonfig.API_KEY
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * ArticlesService
 *
 * Created by Eslam El-Meniawy on 20-Jul-2025 at 3:21 PM.
 */
class ArticlesService(private val _httpClient: HttpClient) {
    private val _country = "us"
    private val _category = "technology"

    suspend fun fetchArticles(): List<ArticleRaw>? {
        val response: ArticlesResponse =
            _httpClient.get("https://newsapi.org/v2/top-headlines?country=$_country&category=$_category&apiKey=$API_KEY")
                .body()

        return response.articles
    }
}