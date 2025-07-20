package elmeniawy.eslam.dailypulse.articles

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
    private val _apiKey = "de4f2ed5402340a4bf9d72ee19f11b43"

    suspend fun fetchArticles(): List<ArticleRaw>? {
        val response: ArticlesResponse =
            _httpClient.get("https://newsapi.org/v2/top-headlines?country=$_country&category=$_category&apiKey=$_apiKey")
                .body()

        return response.articles
    }
}