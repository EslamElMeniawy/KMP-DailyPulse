package elmeniawy.eslam.dailypulse.sources.domain

import elmeniawy.eslam.dailypulse.sources.data.SourceRaw
import elmeniawy.eslam.dailypulse.sources.data.SourcesRepository

/**
 * SourcesUseCase
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 3:48 PM.
 */
class SourcesUseCase(private val _repository: SourcesRepository) {
    suspend fun getSources(forceFetch: Boolean): List<Source>? {
        val sourcesRaw = _repository.getSources(forceFetch)
        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourceRaw>?): List<Source> = when (sourcesRaw) {
        null -> emptyList()
        else -> mapNotNullSources(sourcesRaw)
    }

    private fun mapNotNullSources(sourcesRaw: List<SourceRaw>): List<Source> = sourcesRaw.map {
        Source(
            name = it.name,
            description = it.description,
            languageCountry = getLanguageCountry(it.language, it.country)
        )
    }

    private fun getLanguageCountry(language: String?, country: String?): String =
        listOf(language, country).filter { !it.isNullOrBlank() }.joinToString(" - ")
}