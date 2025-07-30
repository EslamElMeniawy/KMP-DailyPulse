package elmeniawy.eslam.dailypulse.sources.data

import elmeniawy.eslam.dailypulse.BuildKonfig.API_KEY
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * SourcesService
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 3:32 PM.
 */
class SourcesService(private val _httpClient: HttpClient) {
    private val _country = "us"
    private val _category = "technology"

    suspend fun fetchSources(): List<SourceRaw>? {
        val response: SourcesResponse =
            _httpClient.get("https://newsapi.org/v2/top-headlines/sources?country=$_country&category=$_category&apiKey=$API_KEY")
                .body()

        return response.sources
    }
}