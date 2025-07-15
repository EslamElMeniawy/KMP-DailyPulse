@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package elmeniawy.eslam.dailypulse

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

/**
 * BaseViewModel
 *
 * Created by Eslam El-Meniawy on 15-Jul-2025 at 4:31 PM.
 */
actual open class BaseViewModel : ViewModel() {
    actual val scope = viewModelScope
}