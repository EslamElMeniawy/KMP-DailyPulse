@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package elmeniawy.eslam.dailypulse.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

/**
 * DatabaseDriverFactory
 *
 * Created by Eslam El-Meniawy on 29-Jul-2025 at 4:08 PM.
 */
actual class DatabaseDriverFactory() {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(schema = DailyPulseDatabase.Schema, name = "DailyPulseDatabase.db")
}