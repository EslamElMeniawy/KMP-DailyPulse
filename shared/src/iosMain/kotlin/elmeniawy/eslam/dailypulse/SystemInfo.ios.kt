@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package elmeniawy.eslam.dailypulse

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

/**
 * SystemInfo
 *
 * Created by Eslam El-Meniawy on 13-Jul-2025 at 3:07 PM.
 */
actual class SystemInfo {
    actual val osName: String?
        get() = UIDevice.currentDevice.systemName

    actual val osVersion: String?
        get() = UIDevice.currentDevice.systemVersion

    actual val deviceModel: String?
        get() = UIDevice.currentDevice.model

    actual val density: Int?
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun logSystemInfo() {
        NSLog("SystemInfo::osName: $osName, osVersion: $osVersion, deviceModel: $deviceModel, density: $density")
    }
}