@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package elmeniawy.eslam.dailypulse

/**
 * SystemInfo
 *
 * Created by Eslam El-Meniawy on 13-Jul-2025 at 3:04 PM.
 */
expect class SystemInfo {
    val osName: String?
    val osVersion: String?
    val deviceModel: String?
    val density: Int?

    fun logSystemInfo()
}