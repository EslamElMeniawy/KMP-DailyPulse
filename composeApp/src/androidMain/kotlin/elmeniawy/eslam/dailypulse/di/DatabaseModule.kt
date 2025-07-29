package elmeniawy.eslam.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import elmeniawy.eslam.dailypulse.db.DailyPulseDatabase
import elmeniawy.eslam.dailypulse.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * DatabaseModule
 *
 * Created by Eslam El-Meniawy on 29-Jul-2025 at 4:20 PM.
 */

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}