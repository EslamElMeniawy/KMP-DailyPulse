@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package elmeniawy.eslam.dailypulse

import kotlinx.coroutines.CoroutineScope

/**
 * BaseViewModel
 *
 * Created by Eslam El-Meniawy on 15-Jul-2025 at 4:27 PM.
 */
expect open class BaseViewModel() {
    val scope: CoroutineScope
}