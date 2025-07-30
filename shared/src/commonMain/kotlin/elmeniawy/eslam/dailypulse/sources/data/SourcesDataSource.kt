package elmeniawy.eslam.dailypulse.sources.data

import elmeniawy.eslam.dailypulse.db.DailyPulseDatabase

/**
 * SourcesDataSource
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 3:39 PM.
 */
class SourcesDataSource(private val _database: DailyPulseDatabase) {
    fun getAllSources(): List<SourceRaw> =
        _database.dailyPulseDatabaseQueries.selectAllSources(::mapToSourcesRaw).executeAsList()

    fun insertSources(sources: List<SourceRaw>?) {
        _database.dailyPulseDatabaseQueries.transaction {
            sources?.forEach { source ->
                insertSource(source)
            }
        }
    }

    fun clearSources() = _database.dailyPulseDatabaseQueries.removeAllSources()

    private fun mapToSourcesRaw(
        id: String?,
        name: String?,
        description: String?,
        language: String?,
        country: String?
    ): SourceRaw =
        SourceRaw(id, name, description, language, country)

    private fun insertSource(sourceRaw: SourceRaw) {
        _database.dailyPulseDatabaseQueries.insertSource(
            sourceRaw.id,
            sourceRaw.name,
            sourceRaw.description,
            sourceRaw.language,
            sourceRaw.country
        )
    }
}