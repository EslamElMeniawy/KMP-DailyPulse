package elmeniawy.eslam.dailypulse.sources.presentation

import elmeniawy.eslam.dailypulse.BaseViewModel
import elmeniawy.eslam.dailypulse.sources.domain.SourcesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * SourcesViewModel
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 4:00 PM.
 */
class SourcesViewModel(private val _useCase: SourcesUseCase) : BaseViewModel() {
    private val _sourcesState: MutableStateFlow<SourcesState> =
        MutableStateFlow(SourcesState(loading = true))

    val sourcesState: StateFlow<SourcesState> get() = _sourcesState

    init {
        getSources()
    }

    fun getSources(forceFetch: Boolean = false) {
        scope.launch {
            _sourcesState.emit(
                SourcesState(
                    loading = true,
                    sources = _sourcesState.value.sources
                )
            )

            val fetchedSource = _useCase.getSources(forceFetch)
            _sourcesState.emit(SourcesState(sources = fetchedSource))
        }
    }
}