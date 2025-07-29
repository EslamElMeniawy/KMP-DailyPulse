@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")

package elmeniawy.eslam.dailypulse.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver

/**
 * DatabaseDriverFactory
 *
 * Created by Eslam El-Meniawy on 29-Jul-2025 at 4:07 PM.
 */
actual class DatabaseDriverFactory(private val _context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        schema = DailyPulseDatabase.Schema,
        context = _context,
        name = "DailyPulseDatabase.db"
    )
}