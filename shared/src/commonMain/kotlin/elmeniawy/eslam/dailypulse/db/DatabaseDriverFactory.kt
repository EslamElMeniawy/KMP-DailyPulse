@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package elmeniawy.eslam.dailypulse.db

import app.cash.sqldelight.db.SqlDriver

/**
 * DatabaseDriverFactory
 *
 * Created by Eslam El-Meniawy on 29-Jul-2025 at 4:05 PM.
 */
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}