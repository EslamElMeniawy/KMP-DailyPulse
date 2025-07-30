package elmeniawy.eslam.dailypulse.sources.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * SourceRaw
 *
 * Created by Eslam El-Meniawy on 30-Jul-2025 at 3:27 PM.
 */
@Serializable
data class SourceRaw(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("language")
    val language: String?,
    @SerialName("country")
    val country: String?
)