@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package elmeniawy.eslam.dailypulse

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

/**
 * SystemInfo
 *
 * Created by Eslam El-Meniawy on 13-Jul-2025 at 3:06 PM.
 */
actual class SystemInfo {
    actual val osName: String?
        get() = "Android"

    actual val osVersion: String?
        get() = "${Build.VERSION.SDK_INT}"

    actual val deviceModel: String?
        get() = arrayOf(Build.MANUFACTURER, Build.MODEL).filterNotNull().joinToString(" ")

    actual val density: Int?
        get() = round(Resources.getSystem().displayMetrics.density).toInt()

    actual fun logSystemInfo() {
        Log.d(
            TAG,
            "SystemInfo::osName: $osName, osVersion: $osVersion, deviceModel: $deviceModel, density: $density"
        )
    }
}