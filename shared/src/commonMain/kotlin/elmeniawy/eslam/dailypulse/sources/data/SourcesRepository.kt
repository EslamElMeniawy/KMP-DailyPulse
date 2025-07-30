package elmeniawy.eslam.dailypulse.sources.data

/**
 * SourcesRepository
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 3:44 PM.
 */
class SourcesRepository(
    private val _dataSource: SourcesDataSource,
    private val _service: SourcesService
) {
    suspend fun getSources(forceFetch: Boolean): List<SourceRaw>? {
        if (forceFetch) {
            _dataSource.clearSources()
            return fetchSources()
        }

        val sourcesDb = _dataSource.getAllSources()

        if (sourcesDb.isEmpty()) {
            return fetchSources()
        }

        return sourcesDb
    }

    private suspend fun fetchSources(): List<SourceRaw>? {
        val fetchedSources = _service.fetchSources()
        _dataSource.insertSources(fetchedSources)
        return fetchedSources
    }
}