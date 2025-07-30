package elmeniawy.eslam.dailypulse.sources.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * SourcesResponse
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 3:30 PM.
 */
@Serializable
data class SourcesResponse(
    @SerialName("status")
    val status: String?,
    @SerialName("sources")
    val sources: List<SourceRaw>?
)