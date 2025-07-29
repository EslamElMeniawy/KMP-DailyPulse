package elmeniawy.eslam.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import elmeniawy.eslam.dailypulse.db.DailyPulseDatabase
import elmeniawy.eslam.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module

/**
 * DatabaseModule
 *
 * Created by Eslam El-Meniawy on 29-Jul-2025 at 4:36 PM.
 */

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}