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
    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    private fun getArticles() {
        scope.launch {
            delay(1500)
            _articlesState.emit(ArticlesState(error = "Something went wrong"))
            val fetchedArticle = fetchArticles()
            delay(1500)
            _articlesState.emit(ArticlesState(articles = fetchedArticle))
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            title = "Renault shares plunge 16% after French carmaker lowers guidance, appoints new interim CEO - CNBC",
            des = "Renault has lowered its 2025 guidance and announced the appointment of a new interim chief executive officer.",
            date = "2025-07-16",
            imageUrl = "https://image.cnbcfm.com/api/v1/image/108172537-1752650744518-gettyimages-2210802386-20090101250422-99-604248.jpeg?v=1752652382&w=1920&h=1080"
        ),
        Article(
            title = "Nvidia says it will restart sales of a key AI chip to China, in a reversal of US restrictions - CNN",
            des = "American chipmaking giant Nvidia says it plans to resume sales to China of an artificial intelligence chip that’s become part of a global race pitting the world’s biggest economies against each other.",
            date = "2025-07-16",
            imageUrl = "https://media.cnn.com/api/v1/images/stellar/prod/gettyimages-2188577068.jpg?c=16x9&q=w_800,c_fill"
        ),
        Article(
            title = "ASML shares drop 6.5% after the chip giant says it can't confirm that it will grow in 2026 - CNBC",
            des = "ASML reported second-quarter earnings that beat estimates with the its key net bookings figure ahead of consensus.",
            date = "2025-07-16",
            imageUrl = "https://image.cnbcfm.com/api/v1/image/108019821-1723561950847-gettyimages-1900810562-raa-asmlhold240104_npWrR.jpeg?v=1752569290&w=1920&h=1080"
        ),
    )
}