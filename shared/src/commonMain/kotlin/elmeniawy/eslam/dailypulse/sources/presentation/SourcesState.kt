package elmeniawy.eslam.dailypulse.sources.presentation

import elmeniawy.eslam.dailypulse.sources.domain.Source

/**
 * SourcesState
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 3:59 PM.
 */
data class SourcesState(
    val sources: List<Source>? = null,
    val loading: Boolean = false,
    val error: String? = null
)