package elmeniawy.eslam.dailypulse

import android.app.Application
import elmeniawy.eslam.dailypulse.di.sharedKoinModules
import elmeniawy.eslam.dailypulse.di.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * DailyPulseApp
 *
 * Created by Eslam El-Meniawy on 21-Jul-2025 at 3:23 PM.
 */
class DailyPulseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule

        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}